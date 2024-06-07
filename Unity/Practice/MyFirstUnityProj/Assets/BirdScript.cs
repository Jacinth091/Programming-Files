using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BirdScript : MonoBehaviour
{

    public Rigidbody2D playerRigidBody;
    //public Physics2D physics2D;
    public float birdUpVelocity;
    //private bool hasStarted = false;
    // Start is called before the first frame update
    void Start()
    {
        StartCoroutine(GameStart());
    }
    //bool startPlayer()
    //{

    //    if (!Input.GetKeyDown(KeyCode.Space))
    //    {
    //        gravity = 0;
    //        Debug.Log(";Press to Start????");
    //        return false;
    //    }
    //    else
    //    {
    //        Debug.Log("The Game has started???");
    //        gravity = 11;
    //        return true;
    //    }



    //}
    // Update is called once per frame
    void Update()
    {
        playerMovement();
    }

    void playerMovement()
    {

        if (Input.GetKeyDown(KeyCode.Space))
        {
            playerRigidBody.velocity = Vector3.up * birdUpVelocity;

        }


    }

    private IEnumerator GameStart()
    {
        // do stuff here, show win screen, etc.

        // just a simple time delay as an example
        //yield return new WaitForSeconds(2.5f);

        // wait for player to press space
        yield return waitForKeyPress(KeyCode.Space); // wait for this function to return
        playerMovement();

        // do other stuff after key press
    }

    private IEnumerator waitForKeyPress(KeyCode key)
    {
        bool done = false;
        float gravity = playerRigidBody.gravityScale;

        while (!done) // essentially a "while true", but with a bool to break out naturally
        {
            gravity = 0;
            if (Input.GetKeyDown(key))
            {
                gravity = 11;
                done = true; // breaks the loop
            }
            yield return null; // wait until next frame, then continue execution from here (loop continues)
        }

        // now this function returns
    }

}
