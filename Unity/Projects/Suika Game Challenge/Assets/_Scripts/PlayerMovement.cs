using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.UIElements;

public class PlayerMovement : MonoBehaviour
{

    [SerializeField] private Rigidbody2D rb;
    [SerializeField] private BallSpawner ballSpawner;
    private float moveSpd = 5f;
    public PlayerInputActions moveAction;
    private Vector2 moveDirection = Vector2.zero;

    private InputAction plyrMove;
    private InputAction plyrFire;


    private void Awake()
    {
        moveAction = new PlayerInputActions();
        ballSpawner = GameObject.FindGameObjectWithTag("BallSpawner").GetComponent<BallSpawner>();
    }
    private void OnEnable()
    {
        plyrMove = moveAction.Player.Move;
        plyrMove.Enable();

        plyrFire = moveAction.Player.Fire;
        plyrFire.Enable();
        plyrFire.performed += Fire;
    }

    private void OnDisable()
    {
        plyrMove.Disable();
        plyrFire.Disable();

    }


    // Update is called once per frame
    void Update()
    {
        moveDirection = plyrMove.ReadValue<Vector2>();


    }

    private void FixedUpdate()
    {
        if(rb != null)
        {
            rb.velocity = new Vector2((moveDirection.x * moveSpd) + Time.deltaTime, 0);

        }
    }

    private void Fire(InputAction.CallbackContext context)
    {
        Debug.Log("Balls!");
        if(ballSpawner != null)
        {
            ballSpawner.SpawnBall();
        }
    }
}
