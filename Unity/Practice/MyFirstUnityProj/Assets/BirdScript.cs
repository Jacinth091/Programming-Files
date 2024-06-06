using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BirdScript : MonoBehaviour
{

    public Rigidbody2D playerRigidBody;
    //public Physics2D physics2D;
    public float birdUpVelocity;
    private bool hasStarted = false;
    // Start is called before the first frame update
    void Start()
    {
        //startPlayer();
    }
    void startPlayer()
    {
        float gravity = playerRigidBody.gravityScale;
        do
        {
            gravity = 0;
            if (Input.GetKeyDown(KeyCode.Space))
            {
                hasStarted = true;
                gravity = 11;
                break;
            }
         } while (true);


    }
    // Update is called once per frame
    void Update()
    {
        playerMovement();
    }

    void playerMovement()
    {
        if (hasStarted) {

            if (Input.GetKeyDown(KeyCode.Space))
            {
                playerRigidBody.velocity = Vector3.up * birdUpVelocity;

            }
        }

    }
}
