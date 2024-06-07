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
        if (transform.position.x < deadArea)
        {
            Destroy(gameObject);
        }
        else
        {
            pipeMove();
        }
    }

    void pipeMove()
    { 
        int increase = eventLogic.plyrScore;
        if(eventLogic.plyrScore >= 5)
        {
            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            Debug.Log("WOHOOOOO");
        }
        else if (eventLogic.plyrScore >= 10)
        {
            transform.position += (Vector3.left * (pipeScrollSpeed + increase)) * Time.deltaTime;
            Debug.Log("WOHOOOOO");
        }
        else
        {
            Debug.Log("Lamee");
            transform.position += (Vector3.left * pipeScrollSpeed) * Time.deltaTime;

        }

    }

}
