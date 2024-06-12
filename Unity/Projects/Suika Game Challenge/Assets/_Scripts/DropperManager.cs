/*using System.Collections.Generic;
using UnityEngine;

public class DropperManager : MonoBehaviour
{
    public GameObject dropper;
    public Transform dropPosition;
    public Queue<GameObject> objectQueue = new Queue<GameObject>();
    public GameObject objectPrefab;
    public SpriteRenderer nextObjectUI; // SpriteRenderer to show the next object
    public BallPrefabManager ballPrefab;
    public float dropDelay = 1.0f;

    private GameObject currentObject;
    private bool isWaitingForInput = false;
    public GameObject prefab;
    private void Awake()
    {
        ballPrefab = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();

    }
    void Start()
    {
        // Initialize the queue with objects
        //for (int i = 0; i < 5; i++)
        //{
        //    GameObject obj = Instantiate(objectPrefab);
        //    obj.SetActive(false);  // Initially deactivate
        //    objectQueue.Enqueue(obj);
        //}

        objectQueue = ballPrefab.ballQueueData;
         prefab = objectQueue.Dequeue(); // Get the prefab from the queue

        // Show the next object in the UI
        UpdateNextObjectUI();

        // Prepare the first object for dropping
        PrepareNextObject();
    }

    void Update()
    {
        if (!isWaitingForInput && Input.GetMouseButtonDown(0))
        {
            DropObject();
        }
    }

    void UpdateNextObjectUI()
    {
        if (objectQueue.Count > 0)
        {
            GameObject nextObj = objectQueue.Peek();
            nextObjectUI.sprite = nextObj.GetComponent<SpriteRenderer>().sprite;
            nextObjectUI.gameObject.SetActive(true);
        }
        else
        {
            nextObjectUI.gameObject.SetActive(false);
        }
    }

    void PrepareNextObject()
    {
        prefab = objectQueue.Dequeue(); // Get the prefab from the queue

        if (prefab != null)
        {
            currentObject = Instantiate(prefab); // Instantiate a new instance
            currentObject.transform.SetParent(dropper.transform); // Make it a child of the dropper
            currentObject.transform.localPosition = Vector3.zero; // Ensure it appears at the dropper's position
            currentObject.SetActive(true);
            currentObject.GetComponent<Rigidbody2D>().simulated = false; // Disable physics until drop
            UpdateNextObjectUI();
        }
    }


    void DropObject()
    {
        if (currentObject != null)
        {
            isWaitingForInput = true;

            // Drop the object after the delay
            Invoke(nameof(PerformDrop), dropDelay);
        }
    }

    void PerformDrop()
    {
        if (currentObject != null)
        {
            // Reparent to root so it drops independently
            currentObject.transform.SetParent(null);

            // Simulate dropping logic
            Rigidbody2D rb = currentObject.GetComponent<Rigidbody2D>();
            rb.simulated = true;  // Enable physics
            rb.velocity = Vector2.zero; // Ensure no initial velocity

            isWaitingForInput = false;

            // Prepare the next object for dropping
            PrepareNextObject();
        }
    }
}
*/