import java.util.Base64;
import com.vivo.cloud_provision.RequisicaoData;
import com.vivo.cloud_provision.RequisicaoVM;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import com.vivo.vmrequest.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Random;

/**
 * Created by vlima on 1/15/16.
 */
public class RestWorkitemhandler implements WorkItemHandler
{
    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){

                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        System.out.println(hostname);
                        if (hostname.equals("ip-10-97-37-110.salab.gru.redhat.com")) {
                            return true;
                        }
                        return false;
                    }
                });
    }
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager)
    {
        System.out.println("This is a test, please remember it!!!");
        if(workItem.getParameter("requisicao_in")!=null) {
            RequisicaoData requisicaoData;
            requisicaoData = (RequisicaoData) workItem.getParameter("requisicao_in");
             System.out.println("This process was started by" + requisicaoData.getCliente());
            try {
                TemplateFields templateFields= new TemplateFields();
                templateFields.setGuid("e3875bbe-92dd-11e5-88f2-0001a4a9964c");
                Requester requester = new Requester();
                requester.setAuto_approve(true);
                requester.setOwner_last_name("Lima");
                requester.setUser_name("vlima");
                requester.setOwner_first_name("Vitor");
                requester.setOwner_email("vlima@redhat.com");
                for(RequisicaoVM vm : requisicaoData.getListRequisicao())
                {
                    Request request= new Request();
                    request.setVersion(1.1);
                    request.setTemplate_fields(templateFields);
                    request.setRequester(requester);
                    VMFields vmFields = new VMFields();
                    vmFields.setNumber_of_cpus(vm.getNumero_vcpus());
                    vmFields.setVlan("rhevm");//it seems to be a static field
                    vmFields.setVm_memory(vm.getQuantidade_ram().toString());
                    Random r = new Random();
                    vmFields.setVm_name("Test"+ r.nextInt(258));
                    ObjectMapper mapper = new ObjectMapper();
                    request.setVm_fields(vmFields);
                    String jsonInString=null;
                    try
                    {
                        jsonInString = mapper.writeValueAsString(request);
                    }catch (JsonGenerationException e) {
                        e.printStackTrace();
                    } catch (JsonMappingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if(jsonInString!=null) {
                        System.out.println(jsonInString);

                       URL url = new URL("https://ip-10-97-37-110.salab.gru.redhat.com/api/provision_requests/");

                        String encoding = Base64.getEncoder().encodeToString(("vlima:Windows8-19").getBytes());
                        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setDoOutput(true);
                        con.setRequestProperty("Authorization", "Basic " + encoding);
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
                        out.write(jsonInString);
                        out.close();
                        InputStream content = (InputStream) con.getInputStream();
                        BufferedReader in =
                                new BufferedReader(new InputStreamReader(content));
                        String line;
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                        }
                        con.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
                System.out.println("There was an error!");
            }
        workItemManager.completeWorkItem(workItem.getId(), null);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        System.out.println("The work item "+workItem.getId()+" was aborted!");
    }

    public RestWorkitemhandler() {
    }
}