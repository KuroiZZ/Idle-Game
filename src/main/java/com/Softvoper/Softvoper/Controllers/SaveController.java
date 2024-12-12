package com.Softvoper.Softvoper.Controllers;

import com.Softvoper.Softvoper.Models.Save;
import com.Softvoper.Softvoper.Services.SaveSevices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/save")
public class SaveController
{
    @PostMapping(value = "/insert")
    @ResponseBody
    public String Insert(@RequestBody String save)
    {
        SaveSevices.InsertSave(save);
        return "başarılı";
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public String Get(@RequestBody String id)
    {
        return SaveSevices.GetSave(id);
    }

    @GetMapping(value = "/getall")
    @ResponseBody
    public String GetAll()
    {
        return SaveSevices.GetAllSaves();
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public String Delete(@RequestBody String id)
    {
        SaveSevices.DeleteSave(id);
        return "başarılı";
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public String Update(@RequestBody String UpdatedSave)
    {
        SaveSevices.UpdateSave(UpdatedSave);
        return "başarılı";
    }
}
