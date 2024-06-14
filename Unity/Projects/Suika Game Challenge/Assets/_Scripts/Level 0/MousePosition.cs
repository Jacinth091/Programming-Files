using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class MousePosition : MonoBehaviour
{
    // Start is called before the first frame update


    private Vector3 mousePos;
    private Vector3 mousePosWorld;

    private Camera mainCam;

    [SerializeField] private GameObject objtToDrop;
    void Start()
    {
        mainCam = GameObject.FindGameObjectWithTag("MainCamera").GetComponent<Camera>();
    }

    // Update is called once per frame
    void Update()
    {

        if (Mouse.current.leftButton.wasPressedThisFrame) {

            Vector2 mousePos2D = Mouse.current.position.ReadValue();

            mousePos = new Vector3(mousePos2D.x, mousePos2D.y);


            mousePosWorld = mainCam.ScreenToWorldPoint(mousePos);


            Debug.Log($"Mouse Pos World: {mousePosWorld}");
        }

    }
}
