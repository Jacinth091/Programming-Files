using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallPrefabManager : MonoBehaviour
{
    // Start is called before the first frame update
    private List<GameObject> ballList;
    void Start()
    {
        ballList = new List<GameObject>(Resources.LoadAll<GameObject>("Balls"));




    }

    public GameObject objToSpawn()
    {
        //List<GameObject> list = new List<GameObject>();

        //GameObject testObj = null;
        //foreach (GameObject obj in ballList) { 

        //    if(obj.tag.Equals("Basket") || obj.tag.Equals("Football") || obj.tag.Equals("Bowling"))
        //    {
        //        testObj = obj;
        //        list.Add(testObj);
        //        break;

        //    }
        //}

        //list.Add(testObj);

        //int whichObj = Random.Range(0, list.Count -1);
        int whichObj = Random.Range(0, ballList.Count -1);

        return ballList[whichObj];
    }

    // Update is called once per frame
    void Update()
    {
        
    }
}
