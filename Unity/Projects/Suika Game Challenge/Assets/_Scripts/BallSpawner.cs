using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class BallSpawner : MonoBehaviour
{
    //[SerializeField] private GameObject tennis;
    //[SerializeField] private GameObject basket;
    //[SerializeField] private GameObject ball;
    [SerializeField] private BallPrefabManager ballPrefabs;
    [SerializeField] private UpdateManager textUpdate;
    [SerializeField] private GameObject stagedObject;
    private GameObject stagedBallObj = null;
    private GameObject nextBallToStage = null;
    //private bool isEmpty = true;
    //[SerializeField] private Rigidbody2D rb;

    // Update is called once per frame
    private void Awake()
    {
        ballPrefabs = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        textUpdate = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();

    }
    private void Start()
    {
        //ballPrefabs.initBallQueue();


    }

    void Update()
    {

    }

    public void SpawnBall()
    {
        //Instantiate(tennis, transform.position, Quaternion.identity);
        //Instantiate(ball, transform.position, Quaternion.identity);

        /*        if (ballPrefabs != null)
                {
                    // Check and initialize the ball queue if it is not full
                    bool isQueueFull = ballPrefabs.isQueueAvailable;

                    if (isQueueFull)
                    {
                        // Spawn a ball from the queue
                        stagedBallObj = ballPrefabs.getBallFromQueue();
                        if (stagedBallObj != null)
                        {
                            //Debug.Log($"First Obj From Queue: {stagedBallObj.name}");
                            textUpdate.CurrentItem(stagedBallObj.name);
                        }
                        if (stagedBallObj != null)
                        {
                            Debug.Log($"First Obj From Queue: {stagedBallObj.name}");
                            textUpdate.CurrentItem(stagedBallObj.name);
                        }


                        BallPoolManager.spawnObject(ballPrefabs.stagedObjData, transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);

                        nextBallToStage = ballPrefabs.peekNextBall();
                        if (nextBallToStage != null)
                        {
                            Debug.Log($"Second Obj From Queue: {nextBallToStage.name}");
                            textUpdate.NextInQueue(nextBallToStage.name);

                        }
                        else
                        {
                            textUpdate.NextInQueue("Null");

                            Debug.Log($"Second Obj is null!!");

                        }
                    }
                    else
                    {
                        // Handle the case when the queue could not be filled (optional)
                        Debug.LogWarning("The ball queue could not be filled and is still empty.");
                    }


                }*/


        if (ballPrefabs != null) { 
        
            if(ballPrefabs.ballQueueData.Count == 0)
            {
                Debug.LogWarning("BallQueue don't have any items to queue!");
            }
            else
            {
                //Debug.Log($"The Queue has items Queue, the Frist Item: {ballPrefabs.peekNextBall}");
                if (BallPrefabManager.stagedObject != null)
                {
                    //Debug.LogWarning($"{BallPrefabManager.stagedObject}");
                    //Debug.LogWarning("stagedObj is not Null!");
                    BallPoolManager.spawnObject(BallPrefabManager.stagedObject, transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
                    BallPrefabManager.stagedObject = null;
                    BallPrefabManager.nextInQueue = null;
                    //nextBallToStage = BallPrefabManager;
                    //textUpdate.NextInQueue(nextBallToStage.name);

                }
                else if(BallPrefabManager.stagedObject == null)
                {

                    Debug.LogWarning("stagedObj is Null!");
                    stagedBallObj = ballPrefabs.getBallFromQueue();
                    textUpdate.CurrentItem(stagedBallObj.name);
                    BallPoolManager.spawnObject(stagedBallObj, transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
                    nextBallToStage = ballPrefabs.peekNextBall();
                    textUpdate.NextInQueue(nextBallToStage.name);


                }

            }



        }

    }

    public void setStagedParent(GameObject objToStage)
    {
        if (objToStage != null)
        {
            stagedObject = objToStage;
            if (stagedObject.scene.IsValid())
            {
                stagedObject.transform.SetParent(this.transform);
            }
        }
    }


    /*private void UpdateUIWithQueue()
    {
        if (ballPrefabs != null)
        {
            // Set the current item in the UI
            GameObject firstBall = ballPrefabs.peekNextBall();
            if (firstBall != null)
            {
                textUpdate.CurrentItem(firstBall.name);
            }
            else
            {
                textUpdate.CurrentItem("Null");
            }

            // Set the next item in the UI
            GameObject nextBall = ballPrefabs.peekNextBall();
            if (nextBall != null)
            {
                textUpdate.NextInQueue(nextBall.name);
            }
            else
            {
                textUpdate.NextInQueue("Null");
            }
        }
    }*/
}
