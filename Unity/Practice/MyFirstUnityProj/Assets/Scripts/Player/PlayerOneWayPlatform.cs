/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerOneWayPlatform : MonoBehaviour
{
    private GameObject currentOneWayPlat;
    [SerializeField] private CircleCollider2D playerCollider;
    private EventLogic eventLogic;


    void Start()
    {
        eventLogic = GameObject.FindGameObjectWithTag("EventCont").GetComponent<EventLogic>();
    }


    Update is called once per frame
    void Update()
    {
        if (!eventLogic.playerState)
        {
            if (currentOneWayPlat != null)
            {
                StartCoroutine(DisableCollision());

            }
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("OneWayPlat"))
        {

            currentOneWayPlat = collision.gameObject;
        }
    }
    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("OneWayPlat"))
        {
            currentOneWayPlat = null;

        }
    }

    private IEnumerator DisableCollision()
    {
        CircleCollider2D platformCollider = currentOneWayPlat.GetComponent<CircleCollider2D>();

        Physics2D.IgnoreCollision(playerCollider, platformCollider);
        yield return new WaitForSeconds(0.25f);
        Physics2D.IgnoreCollision(playerCollider, platformCollider, false);
    }
}*/
