using System.Collections;
using System.Collections.Generic;
using System.Threading.Tasks;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;


public class LoadingScenes : MonoBehaviour
{
    public static LoadingScenes instance;

    [Header("GamObjects")]
    [SerializeField] private GameObject loadingScreen;
    //[SerializeField] private GameObject mainMenu;

    [Header("Slider")]
    [SerializeField] private Image progressBar;

    [Header("Progress Speed")]
    [SerializeField] private float progressSpeed = 1f;
    private float _targetProgress;

    private AsyncOperation loadOperation;
    private AsyncOperation unloadOperation;
    //private float displayProgress;
    //private float targetProgress;



    private void Awake()
    {
        if (instance == null) {
            instance = this;
            DontDestroyOnLoad(gameObject);
            //LoadGame("MainManu", "null");

        }
        else
        {
            Destroy(gameObject);
        }
    }



    private float totalSceneProgress;
    private float displayProgress;

    public void LoadGame(string sceneToLoad)
    {
        loadingScreen.gameObject.SetActive(true);

        //StartCoroutine(UnloadScene(sceneToLoad, sceneToUnload));
        //SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU);
        //StartCoroutine(GetSceneProgress(sceneToLoad));
        GetSceneProgress(sceneToLoad);


    }
    public IEnumerator UnloadScene(string sceneToLoad, string sceneToUnload)
    {
        // Check if the scene is loaded
        Scene scene = SceneManager.GetSceneByName(sceneToUnload);
        if (scene.isLoaded)
        {
            Debug.Log($"Current Scene; {scene.name}");
            Debug.Log($"Attempting to unload scene: {sceneToUnload}");
            AsyncOperation unloadOperation = SceneManager.UnloadSceneAsync(sceneToUnload);

            while (unloadOperation != null && !unloadOperation.isDone)
            {
                Debug.Log($"Unloading Progress: {unloadOperation.progress}");
                yield return null; // Wait for the unloading to complete
            }

            if (unloadOperation == null)
            {
                Debug.LogError($"Failed to start unloading scene: {sceneToUnload}");
            }
            else
            {
                Debug.Log($"Successfully unloaded scene: {sceneToUnload}");
            }
        }
        else
        {
            Debug.LogWarning($"Scene {sceneToUnload} is not loaded and cannot be unloaded.");
        }


    }
    private async void GetSceneProgress(string sceneToLoad)
    {
        // Initialize display progress

        displayProgress = 0f;
        _targetProgress = 0f;
        progressBar.fillAmount = 0;



        // Unload the current scene
        // Unload the current scene if it is loaded
        SceneManager.UnloadScene(SceneManager.GetActiveScene().name);
        loadOperation = SceneManager.LoadSceneAsync(sceneToLoad);
        loadOperation.allowSceneActivation = false;



  /*      while (!loadOperation.isDone)
        {
            // Update the display progress based on actual loading progress
            _targetProgress = Mathf.Clamp01(loadOperation.progress / 0.9f);


            while (displayProgress < _targetProgress)
            {
                displayProgress += progressSpeed * Time.deltaTime;
                progressBar.fillAmount = Mathf.Clamp01(displayProgress);
                yield return null; // Wait for the next frame
            }

            // Allow scene activation if loading is complete
            if (loadOperation.progress >= 0.9f && displayProgress >= 1f)
            {
                Debug.Log("Scene load progress: " + loadOperation.progress);
                loadOperation.allowSceneActivation = true;
            }

            yield return null; // Wait for the next frame
        }*/

        do
        {
            await Task.Delay(100);
            _targetProgress = Mathf.Clamp01(loadOperation.progress / 0.9f);

        } while (loadOperation.progress < 0.9f);
        await Task.Delay(1000);
        loadOperation.allowSceneActivation = true;

        // Ensure the progress bar is full at the end
        progressBar.fillAmount = 1f;
        loadingScreen.SetActive(false);
    }
    private void Update()
    {
        progressBar.fillAmount = Mathf.MoveTowards(progressBar.fillAmount, _targetProgress, progressSpeed * Time.deltaTime);
    }

}

    /*float displayProgress = 0f;
    //progressBar.value = 0;

    var scene = SceneManager.LoadSceneAsync(sceneName);
    scene.allowSceneActivation = false;
    loadingScreen.SetActive(true);

    while (!scene.isDone)
    {
        // Update the display progress based on actual loading progress
        float targetProgress = Mathf.Clamp01(scene.progress / 0.9f);
        while (displayProgress < targetProgress)
        {
            displayProgress += progressSpeed * Time.deltaTime;
            progressBar.value = Mathf.Clamp01(displayProgress);
            await Task.Delay(10); // Small delay to slow down the progress bar update
        }

        // Allow scene activation if loading is complete
        if (scene.progress >= 0.9f && displayProgress >= 1f)
        {
            scene.allowSceneActivation = true;
        }

        await Task.Yield();
    }

    // Ensure the progress bar is full at the end
    progressBar.value = 1f;
    loadingScreen.SetActive(false);*/


    /*    public void LoadScene(string sceneName)
        {
            StartCoroutine(LoadSceneProgress(sceneName));
        }
        private IEnumerator LoadSceneProgress(string sceneName)
        {


            AsyncOperation loadOperation = SceneManager.LoadSceneAsync(sceneName);
            //AsyncOperation unLoadOperation = SceneManager.UnloadSceneAsync(SceneManager.GetActiveScene().buildIndex);
            loadOperation.allowSceneActivation = false;
            loadingScreen.SetActive(true);

            displayProgress = 0f;
            targetProgress = 0f;
            progressBar.value = 0;

            while (!loadOperation.isDone)
            {
                // Update the display progress based on actual loading progress
                targetProgress = Mathf.Clamp01(loadOperation.progress / 0.9f);
                while (displayProgress < targetProgress)
                {
                    displayProgress += progressSpeed * Time.deltaTime;
                    progressBar.value = Mathf.Clamp01(displayProgress);
                    yield return null; // Wait for the next frame
                }

                // Allow scene activation if loading is complete
                if (loadOperation.progress >= 0.9f && displayProgress >= 1f)
                {
                    Debug.Log("Scene load progress: " + loadOperation.progress);
                    loadOperation.allowSceneActivation = true;
                }

                yield return null; // Wait for the next frame
            }

            // Ensure the progress bar is full at the end
            //progressBar.value = 1f;
            loadingScreen.SetActive(false);
            //scene = null;
        }
    */

  /*  private List<AsyncOperation> scenesLoading = new List<AsyncOperation>();
    private float totalSceneProgress;
    private float displayProgress;
    public float progressSpeed = 1f;
    public void LoadScene(int sceneToLoad, int sceneToUnload, LoadSceneMode sceneMode)
    {
        loadingScreen.gameObject.SetActive(true);
        //scenesLoading.Clear();

        // Start unloading and loading scenes asynchronously
        scenesLoading.Add(SceneManager.UnloadSceneAsync(sceneToUnload));
        scenesLoading.Add(SceneManager.LoadSceneAsync(sceneToLoad, sceneMode));
        StartCoroutine(loadSceneProgress());
        //scenesLoading.Clear();

    }

    private IEnumerator loadSceneProgress()
    {

        //scenesLoading[1].allowSceneActivation = false;
        //loadOperation.allowSceneActivation = false; // Prevent the scene from activating immediately
        //scenesLoading.Add(loadOperation);

        displayProgress = 0f;
        for (int i = 0; i < scenesLoading.Count; i++)
        {
            while (!scenesLoading[i].isDone)
            {
                totalSceneProgress = 0f;

                // Calculate the total progress of both loading operations
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
                    yield return new WaitForSeconds(0.02f);// Small delay to slow down the progress bar

                }
                yield return null;
            }
        }

        //Debug.Log(isLoadingComplete);
        // Ensure the progress bar is full at the end
        progressBar.value = 1f;

        // Allow the scene to activate
        //scenesLoading[1].allowSceneActivation = true;
        //Debug.Log(scenesLoading[1].allowSceneActivation);


        loadingScreen.gameObject.SetActive(false);
    }*/