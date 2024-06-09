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
            string collisionTag = collision.gameObject.tag;

            if(collisionTag != null)
            {
                ballHandlerEvent(collisionTag, collision);
            }


        }
  


 
    }
    private void ballHandlerEvent(string collTag, Collision2D collision)
    {
        switch (collTag)
        {
            default:
                break;

            case "Tennis":
                Debug.Log("Tennis");
                Destroy(collision.gameObject);
                break;
            case "Basket":
                Debug.Log("Basket");

                break;
            case "Beach":
                Debug.Log("Beach");

                break;
            case "Golf":
                Debug.Log("Golf");

                break;
            case "Baseball":
                Debug.Log("Baseball");

                break;
            case "Cricket":
                Debug.Log("Cricket");

                break;
            case "Snooker":
                Debug.Log("Snooker");

                break;
            case "Volley":
                Debug.Log("Volley");

                break;

        }
    }
}
