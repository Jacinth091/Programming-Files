using System.Collections;
using System.Collections.Generic;
using UnityEngine;
//using System;

public class PipeMoveScript : MonoBehaviour
{
    public float pipeScrollSpeed;
    private float deadArea = -39;
    private EventLogic eventLogic;

    // Start is called before the first frame update
    void Start()
    {
        eventLogic = GameObject.FindGameObjectWithTag("EventCont").GetComponent<EventLogic>();
    }

    // Update is called once per frame
    void Update()
    {
        if (eventLogic.playerState)
        {
            if (transform.position.x < deadArea)
            {
                Destroy(gameObject);
            }
            else
            {
                pipeMove();
            }
        }

    }

    void pipeMove()
    {
        float increase = 0;
        if(eventLogic.plyrScore >= 10 && eventLogic.plyrScore < 30)
        {
            increase = eventLogic.plyrScore;
            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            //Debug.Log("WOHOOOOO");
        }
        else if (eventLogic.plyrScore > 30 && eventLogic.plyrScore <= 50)
        {
            increase = eventLogic.plyrScore + 1;

            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            //Debug.Log("WOHOOOOO");
        }
        else if (eventLogic.plyrScore > 50)
        {
            increase = eventLogic.plyrScore + 2;

            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            //Debug.Log("WOHOOOOO");
        }
        else
        {
            //Debug.Log("Lamee");
            increase = eventLogic.plyrScore;
            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            //transform.position += (Vector3.left * pipeScrollSpeed) * Time.deltaTime;

        }

    }

}
