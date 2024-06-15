using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.UIElements;
using UnityEngine.EventSystems;

public class PlayerMovement : MonoBehaviour
{

    [SerializeField] private Rigidbody2D rb;
    [SerializeField] private BallSpawner ballSpawner;
    //private DropperManager dropper;
    private float moveSpd = 4f;
    public PlayerInputActions moveAction;
    private Vector2 moveDirection = Vector2.zero;

    private InputAction plyrMove;
    private InputAction plyrFire;
    private InputAction spaceFire;

    private bool spawnedAnObject = false;
    private float spawnCooldown = 1f;

    public static bool isLeftMouseButtonClicked = false;
    private bool isBallFalling = false;
    private bool isOnCooldown = false;
    private bool isOnContainer = false;
    


    private Vector3 mousePos;
    public static Vector3 mousePosWorld;
    private Camera mainCam;


    private float posXToMove;
    private Vector3 playerNewPos;
    private int clickTimes = 0;




    private void Awake()
    {
        moveAction = new PlayerInputActions();
        ballSpawner = GameObject.FindGameObjectWithTag("BallSpawner").GetComponent<BallSpawner>();
        //dropper = GameObject.Find("Test").GetComponent<DropperManager>();
        mainCam = GameObject.FindGameObjectWithTag("MainCamera").GetComponent<Camera>();
    }
    private void Start()
    {
        //OnEnable();
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
        if (Mouse.current.leftButton.wasPressedThisFrame && !isMouseOverUI())
        {
            clickTimes++;
            Vector2 mousePos2D = Mouse.current.position.ReadValue();

            mousePos = new Vector3(mousePos2D.x, mousePos2D.y);
            mousePosWorld = mainCam.ScreenToWorldPoint(mousePos);
            //mousePosWorld.z = transform.position.z;
            //posXToMove = mousePosWorld.x;

            isLeftMouseButtonClicked = true;
            ClampPlayerToCameraBounds();

            //BallDropAfterClick();


            //Debug.Log($"Mouse Pos World: {mousePosWorld}");
        }


    }

    private void FixedUpdate()
    {
        if(rb != null)
        {
            rb.velocity = new Vector2((moveDirection.x  * moveSpd), 0);

        }


        if (isLeftMouseButtonClicked && !spawnedAnObject && !isOnCooldown && !isMouseOverUI())
        {
            BallDropAfterClick();
            Debug.Log("From FIXED UPDATE FUNCTION");
            //StartCoroutine(BallDropCoolDown());
        }
   



    }
    private bool isMouseOverUI()
    {
        return EventSystem.current.IsPointerOverGameObject();
    }

    private void Fire(InputAction.CallbackContext context)
    {

        bool isSpacePressed = context.control.name == "space";
        bool isRightBtnPressed = context.control.name == "rightButton";


        Debug.LogWarning($"times Clicked: {clickTimes}");
        //context.action.Equals(InputAction.space); 
        if ( ballSpawner != null && !spawnedAnObject && !isOnCooldown)
        {
            if (isLeftMouseButtonClicked || isRightBtnPressed || isSpacePressed) {
                BallDropAfterClick();
                Debug.Log("From FIRE FUNCTION");
            }


        }


        if(clickTimes > 1)
        {
            StartCoroutine(clickTimesCooldown());

        }
  
        
    }

    private IEnumerator CooldownCoroutine()
    {
        isOnCooldown = true;
        yield return new WaitForSeconds(spawnCooldown);
        Debug.LogWarning("COOLDONWN!!!!");
        spawnedAnObject = false;
        isOnCooldown = false;


    }
    private IEnumerator clickTimesCooldown()
    {
        
        yield return new WaitForSeconds(spawnCooldown);
        clickTimes = 0;


    }
    private void BallDropAfterClick()
    {
        if (isLeftMouseButtonClicked) { 
            transform.position = new Vector3(mousePosWorld.x, transform.position.y, transform.position.z);
        }
        spawnedAnObject = true;
        ballSpawner.DropObject();
        isLeftMouseButtonClicked = false;
        StartCoroutine(CooldownCoroutine());

    }
    private void ClampPlayerToCameraBounds()
    {
        Vector3 minBounds = mainCam.ViewportToWorldPoint(new Vector3(0, 0, mainCam.nearClipPlane));
        Vector3 maxBounds = mainCam.ViewportToWorldPoint(new Vector3(1, 1, mainCam.nearClipPlane));

        mousePosWorld.x = Mathf.Clamp(mousePosWorld.x, minBounds.x, maxBounds.x);
        mousePosWorld.y = Mathf.Clamp(mousePosWorld.y, minBounds.y, maxBounds.y);
    }
}
