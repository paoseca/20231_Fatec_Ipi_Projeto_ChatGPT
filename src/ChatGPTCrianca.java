import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ChatGPTCrianca {
    public String explicarCrianca(
      String OPENAI_API_KEY,
      String texto
    ) throws Exception{
      //montar o prompt
      //text block(Java 15+)
      String prompt = 
      """
        Explique sobre esse assunto de maneira simples e em no maximo 30 palavras como se fosse para uma criança muito pequena: %s
      """.formatted(texto);
      var requisicao = new ChatGPTRequest(
        "text-davinci-003",
        prompt,
        100,
        1
      );
  
      var gson = new Gson();
  
      var requisicaoJSON = gson.toJson(requisicao);
  
      RequestBody requestBody = 
        RequestBody.create(
            requisicaoJSON, 
            MediaType.parse("application/json")
        );
      
      OkHttpClient httpClient = new OkHttpClient(); 
  
      Request request = 
        new Request.Builder()
        .url("https://api.openai.com/v1/completions")
        .addHeader("Media-Type", "application/json")
        .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
        .post(requestBody)
        .build();
  
        Response response = httpClient.newCall(request).execute();
        ChatGPTResponse chatGPTResponse =
          gson.fromJson(response.body().string(), ChatGPTResponse.class); // essa 
          String completion = 
            chatGPTResponse.getChoices().get(0).getText(); // esse get(0) é o primeiro elemento da lista
      return completion;
    }
  }
