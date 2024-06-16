/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.InputSystem;

public class MousePosition : MonoBehaviour
{
    // Start is called before the first frame update


    public static Vector3 mousePos;
    public static Vector3 mousePosWorld;
    public static Camera mainCam;

    private int clickTimes = 0;


    public static bool isLeftMouseButtonClicked = false;

    //[SerializeField] private GameObject objtToDrop;
    void Start()
    {
        mainCam = GameObject.FindGameObjectWithTag("MainCamera").GetComponent<Camera>();
    }

    // Update is called once per frame
    void Update()
    {

        if (Mouse.current.leftButton.wasPressedThisFrame && !isMouseOverUI())
        {
            clickTimes++;*//**//*
            Vector2 mousePos2D = Mouse.current.position.ReadValue();

            mousePos = new Vector3(mousePos2D.x, mousePos2D.y);
            mousePosWorld = mainCam.ScreenToWorldPoint(mousePos);
            //mousePosWorld.z = transform.position.z;
            //posXToMove = mousePosWorld.x;

            isLeftMouseButtonClicked = true;
            //ClampPlayerToCameraBounds();

            //BallDropAfterClick();


            Debug.Log($"Mouse Pos World: {mousePosWorld}");
        }

        //StartCoroutine(timer());
    }

    public static bool isMouseOverUI()
    {
        if (EventSystem.current == null)
        {
            Debug.LogError("EventSystem is not present in the scene!");
            return false;
        }

        return EventSystem.current.IsPointerOverGameObject();
    }

    public static void ClampPlayerToCameraBounds()
    {
        Vector3 minBounds = mainCam.ViewportToWorldPoint(new Vector3(0, 0, mainCam.nearClipPlane));
        Vector3 maxBounds = mainCam.ViewportToWorldPoint(new Vector3(1, 1, mainCam.nearClipPlane));

        mousePosWorld.x = Mathf.Clamp(mousePosWorld.x, minBounds.x, maxBounds.x);
        mousePosWorld.y = Mathf.Clamp(mousePosWorld.y, minBounds.y, maxBounds.y);
    }

*//*    public Vector3 mousePosWorldData
    {

        get { return mousePosWorld; }
        set { mousePosWorld = value; }
    }

    public bool isLeftBtnClicked
    {
        get { return isLeftMouseButtonClicked; }
        set { isLeftMouseButtonClicked = value; }
    }*//*
}
*/