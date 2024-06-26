/*using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class BallSpawner : MonoBehaviour
{

    [SerializeField] private BallPrefabManager ballPrefabs;
    [SerializeField] private UpdateManager textUpdate;
    [SerializeField] private GameObject spawnArea;
    

    private GameObject stagedObject;
    private GameObject stagedObjectTemp;
    private GameObject stagedBallObj = null;
    private GameObject nextBallToStage = null;


    // Update is called once per frame
    private void Awake()
    {
        ballPrefabs = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        textUpdate = GameObject.FindGameObjectWithTag("UIManager").GetComponent<UpdateManager>();


    }
    private void Start()
    {
        //ballPrefabs.initBallQueue();

        UpdateSpawnArea();

        PrepareSpawnArea();
    }

    void Update()
    {

    }

    private void UpdateSpawnArea()
    {
        */
/*        if (objectQueue.Count > 0)
                {
                    GameObject nextObj = objectQueue.Peek();
                    nextObjectUI.sprite = nextObj.GetComponent<SpriteRenderer>().sprite;
                    nextObjectUI.gameObject.SetActive(true);
                }
                else
                {
                    nextObjectUI.gameObject.SetActive(false);
                }*/

/*        if (prefab != null)
        {
            currentObject = Instantiate(prefab); // Instantiate a new instance
            currentObject.transform.SetParent(dropper.transform); // Make it a child of the dropper
            currentObject.transform.localPosition = Vector3.zero; // Ensure it appears at the dropper's position
            currentObject.SetActive(true);
            currentObject.GetComponent<Rigidbody2D>().simulated = false; // Disable physics until drop
            UpdateNextObjectUI();
        }*/
/*
        if (stagedObjectTemp != null) { 
        
               
            stagedObjectTemp.transform.SetParent(spawnArea.transform);
        
        
        
        }


        
    }

    public void SpawnBall()
    {
        //Instantiate(tennis, transform.position, Quaternion.identity);
        //Instantiate(ball, transform.position, Quaternion.identity);

        */
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
/*


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



    */
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
    }*//*
}
*/

using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.UI;
public class BallSpawner : MonoBehaviour
{



    [SerializeField] private BallPrefabManager ballPrefabs;
    //[SerializeField] private UpdateManager textUpdate;
    [SerializeField] private GameObject spawnArea;
    [SerializeField] private SpriteRenderer nextObjectArea;
    [SerializeField] private Transform nextObjTransform;
    //[SerializeField] private PlayerMovement playerMovement;

    
    private GameObject stagedObject;
    private GameObject stagedObjectTemp;
    private GameObject currentObj;
    private GameObject nextBallToStage = null;

    private Rigidbody2D rb;

    private Vector3 playerMousePos;

    private float dropDelay = .5f;
    private float appearDelay = 1f;
    private float rotationSpeed = 90f;
    private float TargetAngle;
    private float AngleRotation;


    private bool isWaitingForInput= false;
    private bool isDropping = false;
    private bool isRotationComplete = false;


    private string QueueLayer = "Queue";

    private int TempLayer;
    private int QueueLayerIndex;


    private void Awake()
    {
        ballPrefabs = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        //spawnArea  = GameObject.Find("SpawnArea").GetComponent<GameObject>();
        nextObjectArea = GameObject.Find("The Player").GetComponent<SpriteRenderer>();
        nextObjTransform = GameObject.Find("The Player").GetComponent<Transform>();
        QueueLayerIndex = LayerMask.NameToLayer(QueueLayer);

    }

    private void Start()
    {
        if (ballPrefabs != null) {

            UpdateNextObjectUI();
            PrepareNextObject();
        
        }

    }

    private void Update()
    {
        //playerMousePos = PlayerMovement.mousePosWorld;

    }
    private void FixedUpdate()
    {
        if (isDropping && currentObj != null)
        {

            // Smooth rotation
            if (!isRotationComplete)
            {
                AngleRotation = Mathf.MoveTowardsAngle(currentObj.transform.eulerAngles.z, TargetAngle, rotationSpeed * Time.deltaTime);
                rb.MoveRotation(AngleRotation);

                // Check if rotation is complete
                if (Mathf.Approximately(AngleRotation, TargetAngle))
                {
                    isRotationComplete = true;

                }

            }

        }
    }
    

    void UpdateNextObjectUI()
    {
        if (ballPrefabs.ballQueueData.Count > 0)
        {
            isDropping = false;

            GameObject nextObj = ballPrefabs.peekNextBall();
            Transform nextObjTrans = nextObj.transform;
            Sprite nextSprite = nextObj.GetComponent<SpriteRenderer>().sprite;

            nextObjectArea.sprite = nextSprite;
            nextObjTransform = nextObjTrans;
            nextObjectArea.gameObject.SetActive(true);
            Debug.LogWarning($"NextObj is {nextObj.name}");
        }
        else
        {
            nextObjectArea.gameObject.SetActive(false);
        }
    }

    void PrepareNextObject()
    {
        if(spawnArea.transform.childCount == 0)
        {
            stagedObject = ballPrefabs.getBallFromQueue(); // Get the prefab from the queue

            if (stagedObject != null)
            {
                //currentObj = Instantiate(prefab); // Instantiate a new instance
                StartCoroutine(spawnCurrentBall());

                currentObj.transform.SetParent(spawnArea.transform); // Make it a child of the dropper
                currentObj.transform.localPosition = Vector3.zero; // Ensure it appears at the dropper's position
                currentObj.SetActive(true);

                TempLayer = currentObj.layer;
                currentObj.GetComponent<Rigidbody2D>().simulated = false; // Disable physics until drop

                currentObj.layer = QueueLayerIndex;
                UpdateNextObjectUI();




            }
        }
        else
        {
            Debug.LogWarning("Cannot add new object, parent already has more than one child.");
            //DropObject();
        }
    }


    public void DropObject()
    {
        if (currentObj != null && !isDropping)
        {

            //isWaitingForInput = true;
            // Drop the object after the delay
            StartCoroutine(StartSpawning());

            Debug.LogWarning($"Object layer: {currentObj.layer}");
            StartCoroutine(SetLayerToDef());
            Debug.LogWarning($"Object layer: {currentObj.layer}");



            //PerformDrop();
        }
    }

    void PerformDrop()
    {
        if (currentObj != null)
        {
            // Reparent to root so it drops independently
            currentObj.transform.SetParent(BallPoolManager.parentObj.transform);
    
            //currentObj.transform.position = new Vector3(playerMousePos.x, transform.position.y, transform.position.z);

            // Simulate dropping logic
            rb = currentObj.GetComponent<Rigidbody2D>();
            rb.simulated = true;  // Enable physics
            rb.velocity = Vector2.zero;// Ensure no initial velocity
/*            TargetAngle = 180;
            AngleRotation = Mathf.SmoothDampAngle(rb.transform.localEulerAngles.z, TargetAngle, ref r, 0.3f);
            rb.transform.rotation = Quaternion.Euler(Vector3.forward * AngleRotation);*/
            

            // Prepare the next object for dropping
            StartCoroutine(prepareForNext());




        }
    }
  /*  private void setRandomRot()
    {
        TargetAngle = Random.Range(10, 45);


        AngleRotation = Mathf.SmoothDampAngle(currentObj.transform.eulerAngles.z, TargetAngle, ref r, 0.3f);

    }*/
    private IEnumerator SetLayerToDef()
    {
        yield return new WaitForSeconds(.2f);
        currentObj.layer = TempLayer;

    }
    private IEnumerator StartSpawning()
    {
        float spawnDelay = 0f;
        //isWaitingForInput = true;
        yield return new WaitForSeconds(spawnDelay);
        PerformDrop();
        isDropping = true;
        isRotationComplete = false;
        TargetAngle = Random.Range(-90f, 90f);



    }
    private IEnumerator prepareForNext()
    {
        yield return new WaitForSeconds(appearDelay);
        PrepareNextObject();
        //isWaitingForInput = false;
    }

    private IEnumerator spawnCurrentBall()
    {

        currentObj = BallPoolManager.spawnObject(stagedObject, transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
        Debug.LogWarning($"Current Object is {currentObj.name}");
        yield return new WaitForSeconds(appearDelay);
    }
}