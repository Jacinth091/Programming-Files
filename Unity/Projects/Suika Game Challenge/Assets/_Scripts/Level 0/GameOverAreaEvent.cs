using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameOverAreaEvent : MonoBehaviour
{
    // Start is called before the first frame update
    public int NumberOfItems = 0;
    public int ObjectsThatStayed = 0;
    [SerializeField] private GameObject GameOverArea;
    [SerializeField] private GameObject GameOverCanvas;
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }


    private void OnTriggerEnter2D(Collider2D col)
    {
        bool notAllowed = !col.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
        !col.CompareTag("LeftCollider") &&
        !col.CompareTag("RightCollider") &&
        !col.CompareTag("PlayerColl") &&
        !col.CompareTag("0") &&
        !col.CompareTag("1") &&
        !col.CompareTag("2");

        if (notAllowed) {
            NumberOfItems++;
            Debug.Log($"Object That Triggered: {col.gameObject.name}");
            Debug.Log($"Nunmber of objects that triggered on ENTER: {NumberOfItems}");

        }

    }

    private void OnTriggerStay2D(Collider2D col)
    {
        bool notAllowed = !col.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
        !col.CompareTag("LeftCollider") &&
        !col.CompareTag("RightCollider") &&
        !col.CompareTag("PlayerColl") &&
        !col.CompareTag("0") &&
        !col.CompareTag("1") &&
        !col.CompareTag("2");

        if (notAllowed)
        {
            Debug.LogError($"Object that Stayed: {col.gameObject.name}");
            if(NumberOfItems > 6)
            {
                GameOverArea.SetActive(true);
                GameOverCanvas.SetActive(true);
            }
            Debug.Log($"Nunmber of objects that triggered on STAY: {NumberOfItems}");


        }
    }

    private void OnTriggerExit2D(Collider2D col)
    {
        bool notAllowed = !col.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
        !col.CompareTag("LeftCollider") &&
        !col.CompareTag("RightCollider") &&
        !col.CompareTag("PlayerColl") &&
        !col.CompareTag("0") &&
        !col.CompareTag("1") &&
        !col.CompareTag("2");

        if (notAllowed)
        {
            NumberOfItems--;
            //Debug.Log($"Object That Triggered: {col.gameObject.name}");
            Debug.Log($"Nunmber of objects that triggered on EXIT: {NumberOfItems}");

        }
    }
}
