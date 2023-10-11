package com.sojoo.StoreSpotter.service.apiToDb;

import com.sojoo.StoreSpotter.dao.apiToDb.StoreInfoMapper;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class StoreInfoService {

    private final StoreInfoMapper storeInfoMapper;

    @Autowired
    public StoreInfoService(StoreInfoMapper storeInfoMapper) {
        this.storeInfoMapper = storeInfoMapper;
    }

    public void fetchDataFromPublicAPI() throws Exception {
        System.out.println("fetchDataFromPublicAPI method active");
        try {
            // url 설정
            StringBuilder sb = new StringBuilder();

            sb.append("https://apis.data.go.kr/B553077/api/open/sdsc2/storeListInDong?");
            sb.append("ServiceKey=kXVB%2FzGPSXqZrn%2F1NuCYPZGJONAmxZfu%2BjQDCfDP%2F5uo8QZ%2B6iWdY%2FXrV%2B0gg2z%2BMKVEA%2BrVFLs9l0TVQE2Cug%3D%3D");
            sb.append("&pageNo=" + 1);
            sb.append("&numOfRows=" + 3);
            sb.append("&divId=" + "ctprvnCd");
            sb.append("&key=" + 11);
            sb.append("&indsLclsCd=" + "G2");
            sb.append("&indsMclsCd=" + "G204");
            sb.append("&indsSclsCd=" + "G20405");

            URL url = new URL(sb.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestMethod("GET");
            conn.connect();
            System.out.println(conn.getContentLength());

            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(conn.getInputStream());

            Element root = document.getRootElement();
            Element body = root.getChild("body");
            Element items = body.getChild("items");
            List<Element> itemList = items.getChildren("item");

            if (itemList.isEmpty()) {
                System.out.println("item is null");

            } else {
                for (Element item : itemList) {
                    String bizesId = item.getChildText("bizesId");
                    String bizesNm = item.getChildText("bizesNm");
                    String rdnmAdr = item.getChildText("rdnmAdr");

                    System.out.println("bizesId: " + bizesId);
                    System.out.println("bizesNm: " + bizesNm);
                    System.out.println("rdnmAdr: " + rdnmAdr);
                }
            }

        } catch (Exception e) {
            e.printStackTrace(); // 예외 정보를 출력
        }

        System.out.println("try-catch 구문 종료");
    }
}
