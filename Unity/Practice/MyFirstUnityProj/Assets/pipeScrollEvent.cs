using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pipeScrollEvent : MonoBehaviour
{

    public GameObject pipe;
    private int spawnRate = 5;
    public float timer = 10;
    public int heightOffset = 10;
    //private float currentPosObj = transform.position.x;   
    // Start is called before the first frame update
    void Start()
    {
        //spawnPipes();
    }

    // Update is called once per frame
    void Update()
    {   
        spawnPipes();
        //calcScoreArea();
    }


    void spawnPipes()
    {

        //int currentPos = transform.position.x;
        float lowPoint = transform.position.y - heightOffset;
        float highPoint = transform.position.y + heightOffset;


        if (timer < spawnRate)
        {
            timer += Time.deltaTime;

        }

        else
        {
            Instantiate(pipe, new Vector3(transform.position.x, Random.Range(lowPoint, highPoint), 0), transform.rotation);
            timer = 0;
        }
    }

    public void spawnRateIncrease(int increase)
    {
        spawnRate = increase;
    }
    public void spawnRateDefault()
    {
        spawnRate = 5;
    }
    public float timerData
    {
        get { return timer; }
        set { timer = value; }

    }


}
