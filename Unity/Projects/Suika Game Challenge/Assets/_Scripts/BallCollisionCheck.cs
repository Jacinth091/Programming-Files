/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class CollisionCheck : MonoBehaviour
{

    [SerializeField] private Collision2D ballCollider;
    [SerializeField] private BallPrefabManager ballPrefabManager;
    private UpdateManager updateManager;
    //private BallScript ballScript;
    //private int ballOrder;

    //private Vector3 objPosition;
    //private Quaternion objRotation;

    private int ID;

    private Vector3 pos1;
    private Vector3 pos2;
    private Vector3 mergedPos;
    private GameObject objToSpawn = null;




    // Start is called before the first frame update
    private void Awake()
    {
        ballPrefabManager = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        updateManager = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();

        ID = GetInstanceID();
        //ballOrder = BallScript.BallOrder;

    }

    // Update is called once per frame
    void Update()
    {

    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        int score = 0;
        if (!collision.gameObject.CompareTag("BottomCollider") && !collision.gameObject.CompareTag("LeftCollider") && !collision.gameObject.CompareTag("RightCollider") && !collision.gameObject.CompareTag("defBall"))
        {


            if (collision.gameObject.CompareTag(gameObject.tag))
            {

               if(collision.gameObject.GetComponent<SpriteRenderer>().sprite == GetComponent<SpriteRenderer>().sprite) {

                    if(ID < collision.gameObject.GetComponent<CollisionCheck>().ID) { return; }

                    if(collision.gameObject.tag == "1")
                    {
                        score = 2;
                        Debug.Log("Hello");
                        updateManager.PlayerScore(score);
                        
                    }
                            Debug.Log($"SENDING MESSAGE FROM {gameObject.name}");
                    pos1 = collision.gameObject.transform.position;
                    pos2 = gameObject.transform.position;
                    mergedPos = (pos1 + pos2) / 2f;

                    objToSpawn = spawnBallsAfter(collision.gameObject.tag, mergedPos);
                    BallPoolManager.spawnObject(objToSpawn, mergedPos, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);
                    BallPoolManager.RemoveObjectsToPool(gameObject);




                }
            }



        }



    }

 


    private GameObject spawnBallsAfter(string objTag, Vector3 mergedPos)
    {
        GameObject obj = null;


        if (objTag != null && ballPrefabManager != null)
        {
            int currentBallIndex = 0;

            if (objTag.Equals("9"))
            {
                return obj;
            }
            else
            {
                for (int i = 0; i < ballPrefabManager.ballListData.Count; i++)
                {
                    //bool isFound = false;
                    GameObject currObj = ballPrefabManager.ballListData[i];
                    String colTag = currObj.gameObject.tag;

                    if (!colTag.Equals(objTag))
                    {
                        Debug.LogWarning("notidentified" + $"   --->> {colTag}");

                    }
                    else
                    {
                        currentBallIndex = i + 1;
                        Debug.LogWarning("Entered!");
                        //isFound = true;
                        break;

                    }


                    //if (isFound == true)
                    //{
                    //    //Debug.Log("Identified!!! " + $"{colTag}" + $"CurrentBallIndex: {currentBallIndex}");
                    //}

                }

                if (currentBallIndex < ballPrefabManager.ballListData.Count)
                {
                    obj = ballPrefabManager.ballListData[currentBallIndex];
                    obj.gameObject.transform.position = mergedPos;

                }
            }




        }
        return obj;

    }

}*/

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class CollisionCheck : MonoBehaviour
{

    [SerializeField] private Collision2D ballCollider;
    [SerializeField] private BallPrefabManager ballPrefabManager;
    private UpdateManager updateManager;

    private int ID;

    private Vector3 pos1;
    private Vector3 pos2;
    private Vector3 mergedPos;
    private GameObject objToSpawn = null;

    private bool merging = false;

    private void Awake()
    {
        ballPrefabManager = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        updateManager = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();

        ID = GetInstanceID();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (!merging && ShouldMergeWith(collision.gameObject))
        {

            Physics2D.IgnoreCollision(collision.collider, GetComponent<Collider2D>());
            Physics2D.IgnoreCollision(collision.collider, GetComponent<Collider2D>(), true);
            StartCoroutine(MergeWithDelay(collision.gameObject));
        }
    }

    private IEnumerator MergeWithDelay(GameObject other)
    {
        merging = true;

        yield return new WaitForSeconds(0.08f); // Adjust the delay time as needed

        MergeObjects(other);
        merging = false;
    }

    private bool ShouldMergeWith(GameObject other)
    {
        return !merging &&                                 // Prevent merging if already in merging process
               !other.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
               !other.CompareTag("LeftCollider") &&
               !other.CompareTag("RightCollider") &&
               !other.CompareTag("defBall") &&
               other.CompareTag(gameObject.tag) &&        // Ensure same tag
               other.GetComponent<SpriteRenderer>().sprite == GetComponent<SpriteRenderer>().sprite && // Ensure same sprite
               ID >= other.GetComponent<CollisionCheck>().ID; // Ensure not merging with a lower ID object
    }

    private void MergeObjects(GameObject other)
    {
        int score = 0;
        if (gameObject.CompareTag("1"))
        {
            score = 2;
            updateManager.PlayerScore(score);
        }

        pos1 = other.transform.position;
        pos2 = transform.position;
        mergedPos = (pos1 + pos2) / 2f;

        objToSpawn = spawnBallsAfter(other.tag, mergedPos);
        BallPoolManager.spawnObject(objToSpawn, mergedPos, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
        BallPoolManager.RemoveObjectsToPool(other);
        BallPoolManager.RemoveObjectsToPool(gameObject);
    }

    private GameObject spawnBallsAfter(string objTag, Vector3 mergedPos)
    {
        GameObject obj = null;

        if (objTag != null && ballPrefabManager != null)
        {
            int currentBallIndex = 0;

            if (objTag.Equals("9"))
            {
                return obj;
            }
            else
            {
                for (int i = 0; i < ballPrefabManager.ballListData.Count; i++)
                {
                    GameObject currObj = ballPrefabManager.ballListData[i];
                    string colTag = currObj.gameObject.tag;

                    if (!colTag.Equals(objTag))
                    {
                        Debug.LogWarning("notidentified" + $"   --->> {colTag}");
                    }
                    else
                    {
                        currentBallIndex = i + 1;
                        Debug.LogWarning("Entered!");
                        break;
                    }
                }

                if (currentBallIndex < ballPrefabManager.ballListData.Count)
                {
                    obj = ballPrefabManager.ballListData[currentBallIndex];
                    obj.gameObject.transform.position = mergedPos;
                }
            }
        }
        return obj;
    }
}
