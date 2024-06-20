using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenuManager : MonoBehaviour
{
 /*   ASyncLoader loader;

    private void Start()
    {
        loader = ASyncLoader.Instance;
        if (loader == null)
        {
            Debug.LogWarning("ASyncLoader instance is null in MainMenu Start");
        }
        else
        {
            Debug.Log("ASyncLoader instance successfully assigned in MainMenu Start");
        }
    }

    public void OnLoadButtonPressed(int sceneName)
    {
        if (loader != null)
        {
            loader.LoadScene(sceneName);
        }
        else
        {
            Debug.LogWarning("Loader is null!!");
        }
    }*/

    public void PlayButtonPress(int SceneID)
    {
        if (GameManager.instance != null)
        {
            //GameManager.instance.LoadGame( "MainMenu", "Level(0)");
            GameManager.instance.LoadGame();
        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }
/*
        if (LoadingScenes.instance != null)
        {
            //GameManager.instance.LoadGame( "MainMenu", "Level(0)");
            //LoadingScenes.instance.LoadScene((int)SceneIndex.GAME_lEVEL, "MainMenu");
            string sceneToUnload = SceneManager.GetActiveScene().name;
            LoadingScenes.instance.LoadGame(sceneToLoad);
            Time.timeScale = 1f;
        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }*/

        //SceneManager.LoadScene(sceneName);
    

    }

    public void QuitApplication()
    {
        Application.Quit();
    }

}
