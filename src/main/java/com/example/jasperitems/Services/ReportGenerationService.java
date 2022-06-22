package com.example.jasperitems.Services;

import com.example.jasperitems.database.Item;
//import com.example.jasperitems.database.ItemRepository;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ReportGenerationService {

//    private final ItemRepository itemRepository;

    public List<Item> doGeneratePdfReportFromDbItems() throws FileNotFoundException, JRException {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Book", 14.4f));
        items.add(new Item("Pen", 10.4f));
//        items = itemRepository.findAll();
        InputStream inputStream = new FileInputStream(".\\src\\main\\resources\\reports\\employee.jrxml");
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(items);
        Map parameters = new HashMap();
        JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, ".\\src\\main\\resources\\reports\\employee.pdf");
        return items;
    }
}
