using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{
    // Start is called before the first frame update
    public void OnLoadButtonPressed(int sceneName)
    {
        if (ASyncLoader.Instance != null)
        {
            ASyncLoader.Instance.LoadScene(sceneName);
            //SceneManager.SetActiveScene()
        }
    }

    //public void PlayGame()
    //{
    //    SceneManager.LoadSceneAsync(2);
    //}

    public void QuitApplication()
    {
        Application.Quit();
    }

}
