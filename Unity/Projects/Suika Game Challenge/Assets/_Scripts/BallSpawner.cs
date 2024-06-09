using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallSpawner : MonoBehaviour
{
    //[SerializeField] private GameObject tennis;
    //[SerializeField] private GameObject basket;
    //[SerializeField] private GameObject ball;
    [SerializeField] private BallPrefabManager ballPrefabs;
    //[SerializeField] private Rigidbody2D rb;

    // Update is called once per frame
    private void Awake()
    {


        ballPrefabs = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
        //if(ballPrefabs != null)
        //{
        //    ballPrefabs = gameObject.AddComponent<BallPrefabManager>();
        //}
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
        //Instantiate(ball, transform.position, Quaternion.identity);

        if (ballPrefabs != null) {
            BallPoolManager.spawnObject(ballPrefabs.objToSpawn(),transform.position, Quaternion.identity, BallPoolManager.PoolType.BallObjects);
            //Instantiate(ballPrefabs.objToSpawn(), transform.position, Quaternion.identity);


        }


    }

}
