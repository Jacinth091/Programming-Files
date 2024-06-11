using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallSpawner : MonoBehaviour
{
    //[SerializeField] private GameObject tennis;
    //[SerializeField] private GameObject basket;
    //[SerializeField] private GameObject ball;
    [SerializeField] private BallPrefabManager ballPrefabs;
    [SerializeField] private UpdateManager textUpdate;
    private GameObject stagedBallObj = null;
    private GameObject nextBallToStage = null;
    private bool isEmpty = true;
    //[SerializeField] private Rigidbody2D rb;

    // Update is called once per frame
    private void Awake()
    {
        ballPrefabs = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        textUpdate = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();


    }

    void Update()
    {

    }

    public void SpawnBall()
    {
        //Instantiate(tennis, transform.position, Quaternion.identity);
        //Instantiate(ball, transform.position, Quaternion.identity);

        if (ballPrefabs != null)
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
                BallPoolManager.spawnObject(stagedBallObj, transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);

                nextBallToStage = ballPrefabs.peekNextBall();
                if(nextBallToStage != null)
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


        }
    }


    private void UpdateUIWithQueue()
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
    }
}
