using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;

public class BallPoolManager : MonoBehaviour
{
    public static List<PooledObjectInfo> objectPools = new List<PooledObjectInfo>();
    public static GameObject _objPoolEmptyHolder;
    public static GameObject _objPoolParticleSystem;
    public static GameObject _objBallObjects;
    public enum PoolType
    {
        ParticleSystem,
        BallObjects,
        None
    }
    public static PoolType PoolingType;

    public static void SetupEmpties()
    {
        _objPoolEmptyHolder = new GameObject("Pooled Objects");

        _objPoolParticleSystem = new GameObject("Particle System");
        _objPoolParticleSystem.transform.SetParent(_objPoolEmptyHolder.transform);

        _objBallObjects = new GameObject("Pooled Ball Objects");
        _objBallObjects.transform.SetParent(_objPoolEmptyHolder.transform);
    }

    private void Awake()
    {
        SetupEmpties();
    }
    public static GameObject spawnObject(GameObject objectToSpawn, Vector3 objPos, Quaternion objRota, PoolType poolType = PoolType.None)
    {
        //PooledObjectInfo pool = null;
        //foreach(PooledObjectInfo p in objectPools) {

        //    if(p.LookUpString == objectToSpawn.name)
        //    {
        //        pool = p;
        //        break;
        //    }
        //}

        PooledObjectInfo pool = objectPools.Find(p => p.LookUpString == objectToSpawn.name);


        // If Pool s equal to null, means it didn't find anything, we will add the objToSpwan name to the pool

        if(pool == null)
        {
            pool = new PooledObjectInfo() { LookUpString = objectToSpawn.name};
            objectPools.Add(pool);
        }

        // Checks if there is any inactive gameobjects in the pool

        //GameObject spawnableObject = null;
        //foreach(GameObject obj in pool.InactiveObjects)
        //{
        //    if (obj != null) {
        //        spawnableObject = obj;
        //        break;
            
        //    }
        //}

        GameObject spawnableObj = pool.InactiveObjects.FirstOrDefault();


        // Now checks to see if there is any instaniated objects in the pool, if not we will instantiate ourselves
        
        if(spawnableObj == null)
        {
            GameObject parentObj = SetParentObject(poolType);
            spawnableObj = Instantiate(objectToSpawn, objPos, objRota);

            if (parentObj != null) { 
                spawnableObj.transform.SetParent(parentObj.transform);
            }
        }
        else
        {
            spawnableObj.transform.position = objPos;
            spawnableObj.transform.rotation = objRota;
            pool.InactiveObjects.Remove(spawnableObj);
            spawnableObj.SetActive(true);
        }

        return spawnableObj;
    }

    public static void RemoveObjectsToPool(GameObject obj)
    {
        string newName = obj.name.Substring(0, obj.name.Length - 7) ; 

        PooledObjectInfo pool = objectPools.Find(p => p.LookUpString == newName);

        if(pool == null)
        {
            Debug.LogWarning("You are trying to free an object that isn't pooled " + obj.name);
        }
        else
        {
            obj.SetActive(false);
            pool.InactiveObjects.Add(obj);
            //Destroy(obj);
        }
    }

    private static GameObject SetParentObject(PoolType poolType)
    {
        switch (poolType)
        {
            case PoolType.ParticleSystem:
                return _objPoolParticleSystem;
            case PoolType.BallObjects:
                return _objBallObjects;
            case PoolType.None:
                return null;
            default:
                return null;
        }
    }

}
public class PooledObjectInfo
{
    public string LookUpString;
    public List<GameObject> InactiveObjects = new List<GameObject>();
}
