using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.SocialPlatforms.Impl;

public class UpdateManager : MonoBehaviour
{

/*    [SerializeField] private TextMeshProUGUI nextInQueue;
    [SerializeField] private TextMeshProUGUI currentItem;*/
    [SerializeField] private TextMeshProUGUI playerScore;
    [SerializeField] private BallSpawner ballSpawner;
    private BallPrefabManager ballPrefab;
    private GameObject currentObj;
    private GameObject nextObj;
    private int scoreValue = 0;
    
    // Start is called before the first frame update
    void Start()
    {   

        //currentItem.text = string.Empty;
        playerScore.text = "0";

/*        if (ballPrefab != null)
        {
            //ballPrefab.initBallQueue();
            if (ballSpawner != null)
            {
                currentObj = BallPrefabManager.stagedObject;
                nextObj = BallPrefabManager.nextInQueue;

                //stage = currentObj;
                if (currentObj != null || nextObj !=null)
                {
                    currentItem.text = $@"Current
{currentObj.name}";
                    nextInQueue.text = $@"Next
{nextObj.name}";

                    Debug.Log($"Update Manager (Current): {currentObj.name}");
                    Debug.Log($"Update Manager (Next): {nextObj.name}");
                    //BallPrefabManager.stagedObject = null;

                }
                else
                {
                    //currentItem.text = string.Empty;

                    Debug.Log("Current Obj is null!!");
                }



            }
        }*/


    }
    private void Awake()
    {
        ballPrefab = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();
       


    }
/*    private void OnEnable()
    {
        if (ballPrefab != null)
        {
            //ballPrefab.initBallQueue();
            if (ballSpawner != null)
            {
                currentObj = BallPrefabManager.stagedObject;
                if (currentObj != null)
                {
                    Debug.Log($"Update Manager: {currentObj.name}");

                }
                else
                {
                    Debug.Log("Current Obj is null!!");
                }
                */
/*                if (currentObj != null)
                                {
                                    currentItem.text = currentObj.name;
                                }
                                else
                                {
                                    Debug.LogWarning("The Current Obj is null, you have to instantaite it first!");
                                }*/
/*
            }
        }
    }*/

    // Update is called once per frame
    void Update()
    {
        //if (BallPrefabManager.isBallSpawned)
        //{
        //    ballSpawner.setStagedParent(BallPrefabManager.stagedObject);
        //}
        //else
        //{
        //    ballSpawner.setStagedParent(null);
        //}
    }

    public void PlayerScore(int score)
    {
        //string nextTemp =  ""
        scoreValue += score;
        if (score == 0)
        {
            Debug.LogWarning("The passed Object Name is Null!!");
        }
        else
        {
            playerScore.text = scoreValue.ToString();
        }
    }

/*    public void NextInQueue(string objName)
    {
        string nextTemp = $@"Next
{objName}";
        if (objName == null)
        {
            Debug.LogWarning("The passed Object Name is Null!!");
        }
        else
        {
            nextInQueue.text = nextTemp;
        }
    }

    public void CurrentItem(string objName)
    {
        string nextTemp = $@"Current
{objName}";
        if (objName == null)
        {
            Debug.LogWarning("The passed Object Name is Null!!");
        }
        else
        {
            currentItem.text = nextTemp;
        }
    }*/
}
