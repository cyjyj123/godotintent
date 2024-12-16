package me.futuredreams.godotintent;
import org.godotengine.godot.*;
import org.godotengine.godot.plugin.*;
import android.content.*;
import android.net.Uri

class GodotIntent(godot:Godot) :GodotPlugin(godot){
    override fun getPluginName():String{
        return "GodotIntent"
    }

    @UsedByGodot
    fun startIntent(action:String,extras:Dictionary,dataUri:String=""){
        var it=Intent(action)

        if(dataUri!=""){
            it=Intent(action).apply{data= Uri.parse(dataUri)}
        }

        val keys=extras.keys
        for(v in keys){
            it.putExtra(v,extras.get(v).toString())
        }

        runOnUiThread{
            getActivity()?.startActivity(it)
        }
    }
}