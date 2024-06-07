using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;

public class scoreArea : MonoBehaviour
{

    public EventLogic logicCont;
    //public Collider2D player;
    // Start is called before the first frame update
    void Start()
    {
        logicCont = GameObject.FindGameObjectWithTag("EventCont").GetComponent<EventLogic>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {

        if(collision.gameObject.layer == 3)
        {
            Debug.Log($"{gameObject.name}, has entered the area!");
            logicCont.addPlayerScore();
            logicCont.gameEvent();
        }
    }
}
