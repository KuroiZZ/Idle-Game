package com.Softvoper.Softvoper.Controllers;

import com.Softvoper.Softvoper.Models.Save;
import com.Softvoper.Softvoper.Services.SaveSevices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/save")
public class SaveController
{
    @PostMapping(value = "/insert/{save}")
    public void Insert(@PathVariable String save)
    {
        SaveSevices.InsertSave(save);
    }

    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public String Get(@PathVariable String id)
    {
        return SaveSevices.GetSave(id);
    }
}
