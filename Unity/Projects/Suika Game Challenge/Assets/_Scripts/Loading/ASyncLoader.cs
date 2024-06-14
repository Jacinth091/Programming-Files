using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Threading.Tasks;

public class ASyncLoader : MonoBehaviour
{
    public static ASyncLoader Instance { get; private set; }

    [Header("Scenes")]
    [SerializeField] private GameObject loadingScreen;

    [Header("Slider")]
    [SerializeField] private Slider progressBar;

    //private AsyncOperation loadOperation;

    private void Awake()
    {
        if (Instance == null)
        {
            Instance = this;
            DontDestroyOnLoad(gameObject);
        }
        else
        {
            Destroy(gameObject);
        }
    }

    public async void LoadScene(int sceneName)
    {
        DeactivateCurrentScene();

        float progressVal = 0f;
        AsyncOperation loadOperation = SceneManager.LoadSceneAsync(sceneName);

        loadOperation.allowSceneActivation = false;
        loadingScreen.SetActive(true);

        Debug.Log("Hellow!");
        do
        {

            await Task.Delay(100);
            progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
            progressBar.value = loadOperation.progress;

        } while (progressVal < 0.9f);

        DeactivateCurrentScene();
        await Task.Delay(2000);

        //StartCoroutine(loadLevelASync(sceneName));

        loadOperation.allowSceneActivation = true;
        loadingScreen.SetActive(false);

    }
    private void DeactivateCurrentScene()
    {
        Scene currentScene = SceneManager.GetActiveScene();
        SceneManager.UnloadSceneAsync(currentScene);

        //GameObject[] rootObjects = currentScene.GetRootGameObjects();
        //foreach (GameObject obj in rootObjects)
        //{
        //    obj.SetActive(false);
        //}
    }
}
//IEnumerator loadLevelASync(string sceneName) {

//    while (!loadOperation.isDone)
//    {
//        float progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
//        progressBar.value = progressVal;
//        yield return null;
//    }
//    yield return new WaitForSeconds(100f);


//}
/*
    public void LoadScene(string sceneToLoad)
    {   

        StartCoroutine(LoadLevelASync(sceneToLoad));
    }

    private IEnumerator LoadLevelASync(string sceneToLoad)
    {
        // Load the target scene asynchronously and additively
        AsyncOperation loadOperation = SceneManager.LoadSceneAsync(sceneToLoad);

        loadOperation.allowSceneActivation = false;

        loadingScreen.SetActive(true);
        while (!loadOperation.isDone)
        {
            float progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
            progressBar.value = progressVal;
            yield return null;
        }
        loadOperation.allowSceneActivation = true;

        // Unload the main menu scene
        string currentSceneName = SceneManager.GetActiveScene().name;
        SceneManager.UnloadSceneAsync(currentSceneName);

        // Optionally, you could set the loading screen to inactive once the new scene is loaded
        loadingScreen.SetActive(false);
    }
*/
//private void Start()
//{
//    // Load MainMenu scene additively when the game starts
//    SceneManager.LoadSceneAsync("MainMenu", LoadSceneMode.Additive);
//}

