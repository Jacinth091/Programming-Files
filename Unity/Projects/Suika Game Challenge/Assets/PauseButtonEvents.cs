using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class PauseButtonEvents : MonoBehaviour
{

    [SerializeField] GameObject pauseWindow;

    public static bool isGamePaused = false;
    public void MainMenuScreen(int SceneID)
    {
        if (GameManager.instance != null)
        {
            //GameManager.instance.LoadMenu("Level(0)", "MainMenu");
            GameManager.instance.LoadToMenuFromGame();

            Time.timeScale = 1f;
            //pauseWindow.SetActive(false);
        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }

/*        if (LoadingScenes.instance != null)
        {
            //GameManager.instance.LoadGame( "MainMenu", "Level(0)");
            //LoadingScenes.instance.LoadMenu((int)SceneIndex.MAIN_MENU, "MainLevel");

            string sceneToUnload = SceneManager.GetActiveScene().name;

            LoadingScenes.instance.LoadGame(sceneToLoad);

            Time.timeScale = 1f;
            pauseWindow.SetActive(false);



        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }*/

        //SceneManager.LoadScene(sceneName);


    }
    public void RestartGame(string sceneToLoad)
    {
        if (GameManager.instance != null)
        {
            //GameManager.instance.RestartScene("Level(0)", "Level(0)");
            GameManager.instance.RestartScene();
            Time.timeScale = 1f;
            //pauseWindow.SetActive(false);
        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }

/*        if (LoadingScenes.instance != null)
        {
            //GameManager.instance.LoadGame( "MainMenu", "Level(0)");
            //int currentSceneIndex = SceneManager.GetActiveScene().buildIndex;
            //string sceneToUnload = "MainLevel";
            string sceneToUnload = SceneManager.GetActiveScene().name;
            LoadingScenes.instance.LoadGame(sceneToLoad);

            Time.timeScale = 1f;
            pauseWindow.SetActive(false);



        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }*/
    }
    public void PauseButton()
    {
        pauseWindow.SetActive(true);
        isGamePaused = true;
        Time.timeScale = 0f;
    }
    public void BackButton()
    {
        pauseWindow.SetActive(false);
        isGamePaused = false;
        Time.timeScale = 1f;
    }
}
