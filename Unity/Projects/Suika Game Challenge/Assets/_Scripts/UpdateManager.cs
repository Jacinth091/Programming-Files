using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.SocialPlatforms.Impl;

public class UpdateManager : MonoBehaviour
{

    [SerializeField] private TextMeshProUGUI nextInQueue;
    [SerializeField] private TextMeshProUGUI currentItem;
    [SerializeField] private TextMeshProUGUI playerScore;
    private BallPrefabManager ballPrefab;
    private int scoreValue = 0;
    
    // Start is called before the first frame update
    void Start()
    {   

        nextInQueue.text = string.Empty;
        currentItem.text = string.Empty;
        playerScore.text = "0";
    }
    private void Awake()
    {
        ballPrefab = GameObject.FindGameObjectWithTag("BallQueueManager").GetComponent<BallPrefabManager>();

    }

    // Update is called once per frame
    void Update()
    {
        
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

    public void NextInQueue(string objName)
    {
        string nextTemp = $@"Next
{objName}";
        if(objName == null)
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
    }
}
