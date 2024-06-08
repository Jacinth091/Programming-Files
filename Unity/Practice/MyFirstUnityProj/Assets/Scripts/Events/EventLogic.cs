using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class EventLogic : MonoBehaviour
{

    private int playerScore = 0;
    public Text scoreText;
    public pipeScrollEvent pipeScroll;
    public GameObject gameOverScreen;
    private bool isPlayerAlive = true;


    // Start is called before the first frame update
    void Start()
    {
        //eventLogic = GameObject.FindGameObjectWithTag("LogicCont").GetComponent<EventLogic>();

        //pipeScroll = GameObject.FindGameObjectWithTag("PipeScroll").GetComponent<pipeScrollEvent>();
    }

    // Update is called once per frame
    void Update()
    {
        //gameEvent();

    }

    public void gameEvent()
    {
        int currentScore = playerScore;
        int increase = 0;


        if (currentScore >= 10 && currentScore < 30)
        {
            increase = 4;
            if (pipeScroll != null) { 
                pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += currentScore / Time.deltaTime;
                //pipeMove.increaseScrollSpd(10);
            }
            else
            {
                Debug.Log("Null");
            }

            Debug.Log("This part should speed things up!!!");
            Debug.Log($"{currentScore}");
        }
        else if(currentScore >= 30 && currentScore < 50)
        {
            increase = 3;
            if (pipeScroll != null)
            {
                pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += currentScore / Time.deltaTime;
                //pipeMove.increaseScrollSpd(10);
            }
            else
            {
                Debug.Log("Null");
            }

            ////pipeScroll.timer = 10 ;
            Debug.Log("This part should speed things up!!!");
            Debug.Log($"{currentScore}");
        }
        else if (currentScore >= 50)
        {
            increase = 2;
            if (pipeScroll != null)
            {
                pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += (currentScore / Time.deltaTime) - 5;
                //pipeMove.increaseScrollSpd(10);
            }
            else
            {
                Debug.Log("Null");
            }

            ////pipeScroll.timer = 10 ;
            Debug.Log("This part should speed things up!!!");
            Debug.Log($"{currentScore}");
        }
        else
        {
            if (pipeScroll != null)
            {
                pipeScroll.spawnRateDefault();
                //pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += (currentScore / Time.deltaTime);
                //pipeMove.increaseScrollSpd(10);
            }
            else
            {
                Debug.Log("Null");
            }
            Debug.Log("Hopefull it is working?? HAHAHHA");
        }

    }

    public void restartScene()
    {
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
        playerScore = 0;

    }

    public void gameOverScene() { 
    

        gameOverScreen.SetActive(true);

    }

    public void addPlayerScore(int scoreToAdd)
    {
        playerScore += scoreToAdd;
        scoreText.text = playerScore.ToString();
    }

    public int plyrScore {
        get { return playerScore; }
        set { playerScore = value; }

    }

    public bool playerState
    {
        get { return isPlayerAlive; }
        set { isPlayerAlive = value; }
    
    }
}
