package com.Softvoper.Softvoper.Controllers;

import com.Softvoper.Softvoper.Models.Save;
import com.Softvoper.Softvoper.Services.SaveSevices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/save")
public class SaveController
{
    @PostMapping(value = "/insert/{save}")
    public void Insert(@PathVariable String save)
    {
        SaveSevices.InsertSave(save);
    }
}
