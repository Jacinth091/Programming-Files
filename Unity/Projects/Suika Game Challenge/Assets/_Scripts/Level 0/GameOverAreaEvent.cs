using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class GameOverAreaEvent : MonoBehaviour
{
    // Start is called before the first frame update
    public int NumberOfItems = 0;
    public int ObjectsThatStayed = 0;
    [SerializeField] private GameObject GameOverArea;
    [SerializeField] private GameObject GameOverCanvas;
    [SerializeField] private TextMeshProUGUI TimerText;
    [SerializeField] private TextMeshProUGUI CDTimer;
    [SerializeField] private float remainTime = 30f;
    [SerializeField] private float resetCD = 15f;

    private bool isTimerStart=false;
    private bool _resetTimer = false;

    private int QueueLayer;

    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (isTimerStart)
        {
            StartTimer();
        }
        TimerFormat(remainTime, TimerText);

        if (_resetTimer)
        {
            ResetTimer();
        }
        TimerFormat(resetCD, CDTimer);


    }

    void StartTimer()
    {
        if (remainTime > 0)
        {

            remainTime -= Time.deltaTime;
        }
        else if (remainTime < 0)
        {
            remainTime = 0;
        }


    }

    void ResetTimer()
    {
        if (resetCD > 0)
        {

            resetCD -= Time.deltaTime;
        }
        else if (resetCD < 0)
        {
            resetCD = 0;
        }
/*        else if (resetCD == 0f)
        {
            remainTime = 30f;
            resetCD = 15f;
        }*/

        if(resetCD == 0)
        {
            remainTime = 30f;
            resetCD = 15f;
            Debug.LogError("The Values has been reset!");
            _resetTimer = false;

        }

    }

    void TimerFormat(float time, TextMeshProUGUI textUI)
    {
        int minutes = Mathf.FloorToInt(time / 60);
        int sec = Mathf.FloorToInt(time % 60);
        textUI.text = string.Format("{0:00}:{1:00}", minutes, sec);
    }

    private void OnTriggerEnter2D(Collider2D col)
    {
        bool notAllowed = !col.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
                             !col.CompareTag("LeftCollider") &&
                             !col.CompareTag("RightCollider") &&
                             !col.CompareTag("PlayerColl") &&
                             col.gameObject.layer != LayerMask.NameToLayer("Queue") &&
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
                            col.gameObject.layer != LayerMask.NameToLayer("Queue") &&
                            !col.CompareTag("0") &&
                            !col.CompareTag("1") &&
                            !col.CompareTag("2");

        if (notAllowed)
        {

/*            Debug.LogError($"Object that Stayed: {col.gameObject.name}");
            if(NumberOfItems > 6)
            {
                GameOverArea.SetActive(true);
                GameOverCanvas.SetActive(true);
            }
            Debug.Log($"Nunmber of objects that triggered on STAY: {NumberOfItems}");*/


            if(NumberOfItems >= 4)
            {
                //ObjectsThatStayed++;
                _resetTimer = false;
                isTimerStart = true;
                Debug.LogError("The Timer Has Started!");


                //GameOverArea.SetActive(true);
                //col.gameObject.GetComponent<SpriteRenderer>().sprite = null;
                //GameOverCanvas.SetActive(true);

            }



        }
    }

    private void OnTriggerExit2D(Collider2D col)
    {
        bool notAllowed = !col.CompareTag("BottomCollider") &&      // Prevent merging with specific tags
                             !col.CompareTag("LeftCollider") &&
                             !col.CompareTag("RightCollider") &&
                             !col.CompareTag("PlayerColl") &&
                             col.gameObject.layer != LayerMask.NameToLayer("Queue") &&
                             !col.CompareTag("0") &&
                             !col.CompareTag("1") &&
                             !col.CompareTag("2");

        if (notAllowed)
        {
            NumberOfItems--;

            //Debug.Log($"Object That Triggered: {col.gameObject.name}");
            Debug.Log($"Nunmber of objects that triggered on EXIT: {NumberOfItems}");

            resetCD = 15f;

            _resetTimer = true;

            Debug.LogError("The Reset Cooldown Timer has Started!");
            isTimerStart = false;
        }
    }
}
