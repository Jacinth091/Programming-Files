using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class BirdScript : MonoBehaviour
{

    public Rigidbody2D playerRigidBody;
    //public Physics2D physics2D;
    public float birdUpVelocity;
    private EventLogic eventLogic;
    // Start is called before the first frame update
    void Start()
    {
        //StartCoroutine(GameStart());
        eventLogic = GameObject.FindGameObjectWithTag("EventCont").GetComponent<EventLogic>();

    }

    // Update is called once per frame
    void Update()
    {
        playerMovement();
        checkYPos();
    }

    void playerMovement()
    {

        if (Input.GetKeyDown(KeyCode.Space) && eventLogic.playerState)
        {
            playerRigidBody.velocity = Vector3.up * birdUpVelocity;

        }
        else
        {
            Debug.Log("BOBO AMT hahhahah");
        }
    }

    void checkYPos()
    {
        if (playerRigidBody.transform.position.y >= 19 || playerRigidBody.transform.position.y <= -19)
        {
            playerRigidBody.gravityScale = 0;
            eventLogic.playerState = false;
            eventLogic.gameOverScene();
            if (playerRigidBody.transform.position.y >= 19)
            {
                Vector3 newPosition = new Vector3(transform.position.x, 19, transform.position.z);
                playerRigidBody.transform.position = newPosition;
            }
            else if(playerRigidBody.transform.position.y <= -19)
            {
                Vector3 newPosition = new Vector3(transform.position.x, -19, transform.position.z);
                playerRigidBody.transform.position = newPosition;
            }
        }

    }

    //private void OnTriggerEnter2D(Collider2D collision)
    //{
    //    //eventLogic.gameOverScene();
    //    Debug.Log($"{collision.gameObject.name}");
    //}

    private void OnCollisionEnter2D(Collision2D collision)
    {
            Debug.Log("collision!!!");
            Debug.Log($"{collision.gameObject.name}");
            eventLogic.playerState = false;
            eventLogic.gameOverScene();

    }


    //private IEnumerator GameStart()
    //{
    //    // do stuff here, show win screen, etc.

    //    // just a simple time delay as an example
    //    //yield return new WaitForSeconds(2.5f);

    //    // wait for player to press space
    //    yield return waitForKeyPress(KeyCode.Space); // wait for this function to return
    //    playerMovement();

    //    // do other stuff after key press
    //}

    //private IEnumerator waitForKeyPress(KeyCode key)
    //{
    //    bool done = false;
    //    float gravity = playerRigidBody.gravityScale;

    //    while (!done) // essentially a "while true", but with a bool to break out naturally
    //    {
    //        gravity = 0;
    //        if (Input.GetKeyDown(key))
    //        {
    //            gravity = 11;
    //            done = true; // breaks the loop
    //        }
    //        yield return null; // wait until next frame, then continue execution from here (loop continues)
    //    }

    //    // now this function returns
    //}

}
