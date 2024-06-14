using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallPrefabManager : MonoBehaviour
{
    // Start is called before the first frame update
    private List<GameObject> ballList;
    private Queue<GameObject> ballQueue = new Queue<GameObject>();
    public static GameObject stagedObject;
    public static GameObject nextInQueue;
    //private GameObject currentObj;

    private int queueCapacity = 6;
    public bool isQueueAvailable;
    public static bool isBallSpawned = false;

    //void Start()
    //{

    //}
    private void Awake()
    {
        ballList = new List<GameObject>(Resources.LoadAll<GameObject>("Balls"));
        initBallQueue();
        //Debug.Log($"{ballQueue.Peek()}");

        if (ballQueue.Count != 0)
        {
            stagedObject = getBallFromQueue();
            isBallSpawned = true;
            nextInQueue = peekNextBall();
        }

        //Debug.Log($"Current: {stagedObjData.name}");
        //Debug.Log($"Next In Queue: {nextInQueue.name}");

    }


    // Update is called once per frame
    void Update()
    {
        if(ballQueue != null){
            if (!isQueueAvailable || ballQueue.Count < queueCapacity - 2)
            {
                initBallQueue();
                //stagedObject = getBallFromQueue();
                Debug.Log($"Queue is Available: {ballQueue.Count}");

            }
        }

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
                int randomIndex = Random.Range(0, ballList.Count - 6);
                ballQueue.Enqueue(ballList[randomIndex]);
                //ballQueue.Enqueue(ballList[3]);

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
        //Debug.Log($"Queue count: {ballQueue.Count}");
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
        if (ballQueue.Count != 0)
        {
            return ballQueue.Peek();

        }
        else
        {
            Debug.Log("Ball Queue is Empty!!");
            return null;
        }
    }

    public List<GameObject> ballListData
    {
        get { return ballList; }
        set { ballList = value; }
    }
    public Queue<GameObject> ballQueueData
    {
        get { return ballQueue; }
        set { ballQueue = value; }
    }

/*    public GameObject stagedObjData
    {
        get { return stagedObject; }
        set { stagedObject = value; }
    }*/
}
