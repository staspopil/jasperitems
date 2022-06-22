package com.example.jasperitems.Controller;


import com.example.jasperitems.Services.ReportGenerationService;
import com.example.jasperitems.database.Item;
//import com.example.jasperitems.database.ItemRepository;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@AllArgsConstructor
public class ItemController {

    @Autowired
    ReportGenerationService reportGenerationService;

    @GetMapping("/api/v1/items")
    public List<Item> Items(HttpServletResponse response) throws JRException, FileNotFoundException {
        return reportGenerationService.doGeneratePdfReportFromDbItems();
    }
}
