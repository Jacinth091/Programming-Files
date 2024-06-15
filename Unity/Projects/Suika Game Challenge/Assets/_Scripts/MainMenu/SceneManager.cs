using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
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

    public void OnPress()
    {
        if (GameManager.instance != null)
        {
            GameManager.instance.LoadGame();
        }
        else
        {
            Debug.Log("Game Manager Instance is Null!");
        }
    }

    public void QuitApplication()
    {
        Application.Quit();
    }

}
