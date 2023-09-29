# RecyclerView 

This README provides a step-by-step guide to setting up a RecyclerView in your Android app.
![final](https://github.com/AngryFalcon89/RecyclerView/assets/91687355/3a990839-37f0-4784-b50f-3c5806574099)

## Step 1: Add RecyclerView to MainActivity Layout

- Drag and drop a RecyclerView widget onto your MainActivity layout file.

## Step 2: Create a Single List Item Layout

- Design a single list item layout for your RecyclerView. This layout defines how each item will look.

## Step 3: Create a Model Class

- Define a data class that represents the data for each item in your RecyclerView. For example:

```kotlin
data class Model(
    var videoThumbnail: Int,
    var videoTitle: String,
    var channelThumbnail: Int
)
```

## Step 4: Create an Adapter

- Create an Adapter class that will inflate single item to RecyclerView, returns number of list items to be shown in RecyclerView and also Populates given list items in single element

```kotlin
//step1: Create adapter class
//step3: inherit from RecyclerView.adapter and pass Adapter.ViewHolder as generic type
//step4: implement member functions
class Adapter(var dataList: ArrayList<Model>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
//step2: create custom ViewHolder class and inherit from RecyclerView.ViewHolder by passing root XML as a constructor
    inner class ViewHolder (var binding : SingleItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //step5: design file and Model files are combined in onCreateView function
        //we say that ViewHolder class will get SingleItemBinding and will inflate it in root file
        //but we have not created its object that is further getting attached to binding.root
        //normal XML gayi -> ViewHolder return hua
        var binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    //size of recyclerView shown is decided in this function
    override fun getItemCount(): Int {
        return dataList.size  //size = dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //step6: set the data in the inflated recyclerViewList
        holder.binding.videoThumbnail.setImageResource(dataList.get(position).videoThumbnail)
        holder.binding.channelThumbnail.setImageResource(dataList.get(position).channelThumbnail)
        holder.binding.videoTitle.text = dataList.get(position).videoTitle
        }
    }
```

## Step 5: Add changes in MainActivity 

```kotlin
class MainActivity : AppCompatActivity() {
          
    //step1: Create ViewBinding of MainActivity
    lateinit var binding :ActivityMainBinding
            
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    //ActivityMainBinding is inflated i.e. design having RecyclerView is inflated
    //
    //inflate(layoutInflater): This method is used to inflate (create) an instance of the ActivityMainBinding class.
    // In Android, "inflating" typically refers to the process of converting an XML layout into actual View objects that
    // can be used within your activity.
    //
    //layoutInflater: This is an instance of the LayoutInflater class,
    // which is used to create View objects from XML layout resources.
    // It's a crucial part of the Android framework that allows you to turn XML layouts into actual UI components.

    //step2: Initialize Binding with ActiityMainBinding and inflate it with layoutInflater
    binding = ActivityMainBinding.inflate(layoutInflater)

    //step3: Set this mainActivity Binding to mainView 
    setContentView(binding.root)

    //step4: Create dataList to be populated in RecyclerView
    var dataList = ArrayList<Model>()
    dataList.add(Model(R.drawable.image0,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image1,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image2,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image3,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image4,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image5,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image1,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image7,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image8,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))
    dataList.add(Model(R.drawable.image9,"Hello this is my RecyclerView Example and i Have implemented it to learn and understand RecyclerView",R.drawable.profile_pic))

    //Step5: Create adapter class object and pass dataList 
    var adapter = Adapter(dataList)
              
    //Step6: call layout manager and assign LinearLayoutManager to it or something else
    binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
              
    //step7: assign Adapter class object to MainActivityBinding adapter
    binding.rv.adapter = adapter
    }
}
```
