using System.Collections;
using System.Collections.Generic;
using System.Threading;
using UnityEngine;
using UnityEngine.UI;

public class EventLogic : MonoBehaviour
{

    private int playerScore = 0;
    public Text scoreText;
    //private EventLogic eventLogic;
    //public PipeMoveScript pipeMove;
    public pipeScrollEvent pipeScroll;
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


        if (currentScore >= 5)
        {
            increase = 4;
            if (pipeScroll != null) { 
                pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += currentScore * Time.deltaTime;
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
        else if(currentScore >= 10)
        {
            increase = 3;
            if (pipeScroll != null)
            {
                pipeScroll.spawnRateIncrease(increase);
                pipeScroll.timerData += currentScore * Time.deltaTime;
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
            pipeScroll.spawnRateDefault();
            Debug.Log("Hopefull it is working?? HAHAHHA");
        }

    }

    public void addPlayerScore()
    {
        playerScore++;
        scoreText.text = playerScore.ToString();
    }

    public int plyrScore {
        get { return playerScore; }
        set { playerScore = value; }

    }
}
