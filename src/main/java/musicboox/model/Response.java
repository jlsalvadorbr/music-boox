package musicboox.model;

public class Response {

  private int status;
  private String scoreGuid;

  public int getStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public String getScoreGuid() {
    return scoreGuid;
  }
  
  public void setScoreGuid(String scoreGuid) {
    this.scoreGuid = scoreGuid;
  }
}
