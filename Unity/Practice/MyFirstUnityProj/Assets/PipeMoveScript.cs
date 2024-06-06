using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PipeMoveScript : MonoBehaviour
{
    public float pipeScrollSpeed;
    private float deadArea = -39;

    // Start is called before the first frame update
    void Start()
    {
        
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

        transform.position += (Vector3.left * pipeScrollSpeed) * Time.deltaTime;

    }
}
