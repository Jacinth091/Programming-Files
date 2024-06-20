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
    [SerializeField] private AudioClip soundFXClip;
    private UpdateManager updateManager;
    private static Dictionary<string, List<GameObject>> collidingObjects = new Dictionary<string, List<GameObject>>();

    private int ID;
    private int mergingCount = 2;

    private Vector3 pos1;
    private Vector3 pos2;
    private Vector3 mergedPos;
    private GameObject objToSpawn = null;

    private bool merging = false;
    private int merge = 0;

    private void Awake()
    {
        ballPrefabManager = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        updateManager = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();

        ID = GetInstanceID();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (ShouldMergeWith(collision.gameObject))
        {
            string tag = gameObject.tag;

            if (!collidingObjects.ContainsKey(tag))
            {
                collidingObjects[tag] = new List<GameObject>();
            }

            collidingObjects[tag].Add(gameObject);
            collidingObjects[tag].Add(collision.gameObject);

            if (collidingObjects[tag].Count == 2 && !merging)
            {
                merging = true;
                //StartCoroutine(MergeWithDelay(collision.gameObject));
            }
            else if (collidingObjects[tag].Count > 2)
            {
                collidingObjects[tag].Remove(collision.gameObject);
                Debug.Log("Removed Extra!");
            }
           
        }
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (ShouldMergeWith(collision.gameObject))
        {
            string tag = gameObject.tag;

            if (collidingObjects.ContainsKey(tag))
            {
                collidingObjects[tag].Remove(gameObject);
                collidingObjects[tag].Remove(collision.gameObject);

                if (collidingObjects[tag].Count == 0)
                {
                    collidingObjects.Remove(tag);
                }
            }
        }
    }

    private IEnumerator MergeWithDelay(GameObject other)
    {
        yield return new WaitForSeconds(0.1f); // Adjust the delay time as needed

        MergeObjects(other);
        merging = false;
        string tag = gameObject.tag;
        if (collidingObjects.ContainsKey(tag))
        {
            collidingObjects[tag].Clear();
        }
    }

    private bool ShouldMergeWith(GameObject other)
    {
        return !merging &&                          // Prevent merging if already in merging process
               !other.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
               !other.CompareTag("LeftCollider") &&
               !other.CompareTag("RightCollider") &&
               !other.CompareTag("defBall") &&
               other.CompareTag(gameObject.tag) &&        // Ensure same tag
               other.GetComponent<SpriteRenderer>().sprite == GetComponent<SpriteRenderer>().sprite && // Ensure same sprite
               ID > other.GetComponent<CollisionCheck>().ID; // Ensure not merging with a lower ID object
    }

    private void MergeObjects(GameObject other)
    {

        Scoring();

        pos1 = other.transform.position;
        pos2 = transform.position;
        mergedPos = (pos1 + pos2) / 2f;

        objToSpawn = spawnBallsAfter(other.tag, mergedPos);
        BallPoolManager.spawnObject(objToSpawn, mergedPos, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
        SoundFXManager.instance.PlaySoundFXClip(soundFXClip, objToSpawn.transform, 1f);
        BallPoolManager.RemoveObjectsToPool(other);
        BallPoolManager.RemoveObjectsToPool(gameObject);
    }
    private void Scoring()
    {
        int score = 0;
        switch (gameObject.tag)
        {
            case "0":
                score = 1;
                break;
            case "1":
                score = 3;
                break;
            case "2":
                score = 6;
                break;
            case "3":
                score = 10;
                break;
            case "4":
                score = 15;
                break;
            case "5":
                score = 21;
                break;
            case "6":
                score = 28;
                break;
            case "7":
                score = 36;
                break;
            case "8":
                score = 45;
                break;
        }
        updateManager.PlayerScore(score);
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
