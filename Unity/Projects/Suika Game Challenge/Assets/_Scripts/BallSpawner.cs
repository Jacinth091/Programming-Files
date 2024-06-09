using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallSpawner : MonoBehaviour
{
    //[SerializeField] private GameObject tennis;
    //[SerializeField] private GameObject basket;
    [SerializeField] private GameObject ball;
    //[SerializeField] private Rigidbody2D rb;

    // Update is called once per frame
    private void Start()
    {
        //ball = GetComponent<GameObject>();
        //if(ball != null)
        //{
        //    ball = GameObject.FindGameObjectWithTag(gameObject.tag).GetComponent<GameObject>();
        //}
        if (ball != null) {
            return;
        }
    }

/*    private void Start()
    {
        //rb = GetComponent<Rigidbody2D>();
        //if (rb != null)
        //{
        //    rb = ball.AddComponent<Rigidbody2D>();
        //}

        //rb.AddForce(new Vector2(1.0f, 1.0f), ForceMode2D.Impulse);

    }*/

    void Update()
    {
        
    }
    public void msg()
    {
        Debug.Log("BOBO");
    }
    public void SpawnBall()
    {
        //Instantiate(tennis, transform.position, Quaternion.identity);
        Instantiate(ball, transform.position, Quaternion.identity);

    }

}
