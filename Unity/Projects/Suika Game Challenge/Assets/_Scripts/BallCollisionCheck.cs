using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CollisionCheck : MonoBehaviour
{

    [SerializeField] private Collision2D ballCollider;
    //[SerializeField] private BallScript ballScript;
    //[SerializeField] private Rigidbody2D rb;



    // Start is called before the first frame update
    private void Awake()
    {
        //basket = GameObject.FindGameObjectWithTag("Basket").GetComponent<GameObject>();
        //ballScript = GetComponent<BallScript>();
        //if(ballScript != null)
        //{
        //    ballScript = gameObject.AddComponent<BallScript>();
        //}
        //else
        //{
        //    Debug.Log("BALL SCRIPT IS NULL!!!");
        //}

    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        Debug.Log("Collide with " + $"{collision.gameObject.name}");

        if (!collision.gameObject.CompareTag("BottomCollider") && !collision.gameObject.CompareTag("LeftCollider") && !collision.gameObject.CompareTag("RightCollider") && !collision.gameObject.CompareTag("defBall"))
        {
            string collisionTag = collision.gameObject.name.Substring(0, collision.gameObject.name.Length -7);

            if(collisionTag != null)
            {
                ballHandlerEvent(collisionTag, gameObject);
            }


        }
  


 
    }
    private void ballHandlerEvent(string collTag, GameObject obj)
    {


        string gameObjName = obj.name.Substring(0, obj.name.Length - 7);
        Debug.LogWarning(collTag);
        Debug.LogWarning(gameObjName);
        if (collTag.Equals(gameObjName)) {

            switch (collTag)
            {
                case "Tennis":
                    Debug.Log("Tennis");
                    //Destroy(collision.obj);
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);
                    break;
                case "Basketball":
                    Debug.Log("Basketball");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    Debug.LogWarning("BASKET BALLLL!!!1");
                    //Destroy(obj);

                    break;
                case "Beach":
                    Debug.Log("Beach");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);


                    break;
                case "Golf":
                    Debug.Log("Golf");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);


                    break;
                case "Baseball":
                    Debug.Log("Baseball");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);
                    break;
                case "Cricket":
                    Debug.Log("Cricket");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);


                    break;
                case "Snooker":
                    Debug.Log("Snooker");
                    BallPoolManager.RemoveObjectsToPool(obj);
                    //Destroy(obj);


                    break;
                case "Volley":
                    Debug.Log("Volley");
                    //Destroy(obj);
                    BallPoolManager.RemoveObjectsToPool(obj);

                    //BallPoolManager.RemoveObjectsToPool(obj);

                    break;
                case "Bowling":
                    Debug.Log("Bowling Ball!!");
                    //Destroy(obj);
                    BallPoolManager.RemoveObjectsToPool(obj);

                    //BallPoolManager.RemoveObjectsToPool(obj);

                    break;
                case "Football":
                    Debug.Log("footBall!!");
                    //Destroy(obj);
                    BallPoolManager.RemoveObjectsToPool(obj);

                    //BallPoolManager.RemoveObjectsToPool(obj);

                    break;

                default:
                    Debug.LogWarning("Not Identified!");
                    Debug.LogWarning(collTag);
                    Debug.LogWarning(gameObjName);
                    break;

            }


        }


    }
}
