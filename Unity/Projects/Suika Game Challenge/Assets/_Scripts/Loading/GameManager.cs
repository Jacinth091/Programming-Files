using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Threading.Tasks;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;
    public GameObject loadingScreen;
    public Slider progressBar;

    private void Awake()
    {
        instance = this;

        SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU, LoadSceneMode.Additive);

    }

    List<AsyncOperation> scenesLoading = new List<AsyncOperation>();
    private float totalSceneProgress;
    private float displayProgress;
    public float progressSpeed = 1f;
    public void LoadGame()
    {
        loadingScreen.gameObject.SetActive(true);
        scenesLoading.Add(SceneManager.UnloadSceneAsync((int)SceneIndex.MAIN_MENU));
        scenesLoading.Add(SceneManager.LoadSceneAsync((int)SceneIndex.GAME_lEVEL));
        //SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU);
        StartCoroutine(GetSceneProgress());

    }

    private IEnumerator GetSceneProgress()
    {
        // Initialize display progress
        displayProgress = 0f;

        for (int i = 0; i < scenesLoading.Count; i++)
        {
            while (!scenesLoading[i].isDone)
            {
                totalSceneProgress = 0f;
                foreach (AsyncOperation operation in scenesLoading)
                {
                    totalSceneProgress += operation.progress;
                }

                totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

                // Gradually increase the display progress to the actual progress
                while (displayProgress < totalSceneProgress)
                {
                    displayProgress += progressSpeed;
                    progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                    yield return new WaitForSeconds(0.02f); // Small delay to slow down the progress bar
                }

                yield return null;
            }
        }

        // Ensure the progress bar is full at the end
        progressBar.value = 1f;
        loadingScreen.gameObject.SetActive(false);
    }
}






/*using System.Collections;
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
    [SerializeField] private  Slider progressBar;

    //private AsyncOperation loadOperation;

    private void Awake()
    {
        Debug.Log("ASyncLoader Awake called");
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
}*/
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

