using System.Collections;
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

 

/*
    private void ballHandlerEvent(Collision2D collision, GameObject obj)
    {


        string gameObjName = obj.name.Substring(0, obj.name.Length - 7);
        string collTag = collision.gameObject.name.Substring(0, collision.gameObject.name.Length - 7);

        //Debug.LogWarning(collTag);
        //Debug.LogWarning(gameObjName);
        if (collTag.Equals(gameObjName))
        {

            switch (collTag)
            {

                case "0_Golf":
                    Debug.Log("Golf");
                    pos1 = collision.gameObject.transform.position;
                    pos2 = gameObject.transform.position;
                    mergedPos = (pos1 + pos2) / 2f;

                    objToSpawn = spawnBallsAfter(collision.gameObject.tag, mergedPos);
                    BallPoolManager.spawnObject(objToSpawn, mergedPos, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
                    //BallPoolManager.RemoveObjectsToPool(collision.gameObject);
                    //BallPoolManager.RemoveObjectsToPool(gameObject);
                    break;

                case "1_Snooker":
                    Debug.Log("Snooker");
                    pos1 = collision.gameObject.transform.position;
                    pos2 = gameObject.transform.position;
                    mergedPos = (pos1 + pos2) / 2f;

                    objToSpawn = spawnBallsAfter(collision.gameObject.tag, mergedPos);
                    BallPoolManager.spawnObject(objToSpawn, mergedPos, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
                    //BallPoolManager.RemoveObjectsToPool(collision.gameObject);
                    //BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "2_Cricket":
                
                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);
                    //BallPoolManager.RemoveObjectsToPool(ball2);
                    break;
                case "3_Tennis":
                    Debug.Log("Tennis");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "4_Soft":
                    Debug.Log("Baseball");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "5_Volley":
                    Debug.Log("Volley");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "6_Soccer":
                    Debug.Log("footBall!!");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "7_Bowling":
                    Debug.Log("Bowling Ball!!");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    break;
                case "8_Beach":
                    Debug.Log("Beach");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);
 
                    break;

                case "9_Basket":
                    Debug.Log("Basketball");

                    BallPoolManager.RemoveObjectsToPool(collision.gameObject);

                    Debug.LogWarning("BASKET BALLLL!!!1");
                    break;

                default:
                    Debug.LogWarning("Not Identified!");
                    Debug.LogWarning(collTag);
                    Debug.LogWarning(gameObjName);
                    break;

            }


        }


    }
*/
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
                        Debug.LogWarning("notidentified" + $"{colTag}");

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

}