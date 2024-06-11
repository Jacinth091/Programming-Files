using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallPrefabManager : MonoBehaviour
{
    // Start is called before the first frame update
    private List<GameObject> ballList;
    private Queue<GameObject> ballQueue;
    private int queueCapacity = 6;
    public bool isQueueAvailable;

    //void Start()
    //{

    //}
    private void Awake()
    {
        ballQueue = new Queue<GameObject>(queueCapacity);
        ballList = new List<GameObject>(Resources.LoadAll<GameObject>("Balls"));

    }

    //public GameObject objToSpawn()
    //{
    //    int whichObj = Random.Range(0, ballList.Count -5);

    //    return ballList[whichObj];
    //}


    // Update is called once per frame
    void Update()
    {
        //isQueueAvailable = initBallQueue();

        //Debug.Log($"Queue is Available: {ballQueue.Count}");
        //if(ballQueue.Count == 3)
        //{

        //}
        //Debug.Log($"Queue Item Count: {ballQueue.Count}");
        if(ballQueue != null){
            if (!isQueueAvailable || ballQueue.Count < queueCapacity - 2)
            {
                initBallQueue();
                Debug.Log($"Queue is Available: {ballQueue.Count}");

            }
        }

        //else
        //{
        //    Debug.Log("The Queue is Available!");
        //}

    }


    public void initBallQueue()
    {
        //isQueueAvailable = false;

        // If the queue is empty, start filling it
        if (ballQueue.Count < queueCapacity || ballQueue.Count == 0)
        {
            for (int i = 0; i < queueCapacity; i++)
            {
                // Select a random index and enqueue the ball
                int randomIndex = Random.Range(0, ballList.Count - 5);
                ballQueue.Enqueue(ballList[randomIndex]);

                // Check if the queue has reached its capacity
                if (ballQueue.Count == queueCapacity)
                {
                    isQueueAvailable = true;
                    break;
                }
            }
        }
        // Check the final state of the queue
        if (ballQueue.Count == queueCapacity)
        {
            isQueueAvailable = true;
        }
        else
        {
            isQueueAvailable = false;
        }

        // Log the current count of the queue
        Debug.Log($"Queue count: {ballQueue.Count}");
    }


    public GameObject getBallFromQueue()
    {
        //Debug.Log($"dequeued Obj {ballQueue.Dequeue().gameObject.name}");
        if (ballQueue.Count != 0)
        {
            return ballQueue.Dequeue();
        }
        else
        {
            Debug.Log("Ball Queue is Empty!!");
            return null;
        }

    }

    public GameObject peekNextBall()
    {
        /*     if(ballQueue.Count != 0)
             {

             }
             else
             {
                 Debug.Log("Ball Queue is Empty!!");
                 return null;
             }*/
        return ballQueue.Peek();
    }

    public List<GameObject> ballListData
    {
        get { return ballList; }
        set { ballList = value; }
    }

}
