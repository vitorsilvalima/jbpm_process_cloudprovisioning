package com.vivo.cloud_provision;

/**
 * This class was automatically generated by the data modeler tool.
 */

@org.kie.api.remote.Remotable
public class RequisicaoVM implements java.io.Serializable
{
   static final long serialVersionUID = 1L;
   private Integer quantidade_vm;
   private Integer numero_vcpus;
   private Integer quantidade_ram;
   private java.lang.String so;
   private java.lang.String ip_producao;

   private java.lang.String ip_backup;

   private java.lang.String ip_gerenciamento;

   public java.lang.String getSo()
   {
      return this.so;
   }

   public void setSo(java.lang.String so)
   {
      this.so = so;
   }

   public java.lang.String getIp_producao()
   {
      return this.ip_producao;
   }

   public void setIp_producao(java.lang.String ip_producao)
   {
      this.ip_producao = ip_producao;
   }

   public java.lang.String getIp_backup()
   {
      return this.ip_backup;
   }

   public void setIp_backup(java.lang.String ip_backup)
   {
      this.ip_backup = ip_backup;
   }

   public java.lang.String getIp_gerenciamento()
   {
      return this.ip_gerenciamento;
   }

   public void setIp_gerenciamento(java.lang.String ip_gerenciamento)
   {
      this.ip_gerenciamento = ip_gerenciamento;
   }

   public RequisicaoVM()
   {
   }

   public java.lang.Integer getQuantidade_vm()
   {
      return this.quantidade_vm;
   }

   public void setQuantidade_vm(java.lang.Integer quantidade_vm)
   {
      this.quantidade_vm = quantidade_vm;
   }

   public java.lang.Integer getQuantidade_ram()
   {
      return this.quantidade_ram;
   }

   public void setQuantidade_ram(java.lang.Integer quantidade_ram)
   {
      this.quantidade_ram = quantidade_ram;
   }

   public java.lang.Integer getNumero_vcpus()
   {
      return this.numero_vcpus;
   }

   public void setNumero_vcpus(java.lang.Integer numero_vcpus)
   {
      this.numero_vcpus = numero_vcpus;
   }

   public RequisicaoVM(java.lang.Integer quantidade_vm,
         java.lang.Integer numero_vcpus, java.lang.Integer quantidade_ram,
         java.lang.String so, java.lang.String ip_producao,
         java.lang.String ip_backup, java.lang.String ip_gerenciamento)
   {
      this.quantidade_vm = quantidade_vm;
      this.numero_vcpus = numero_vcpus;
      this.quantidade_ram = quantidade_ram;
      this.so = so;
      this.ip_producao = ip_producao;
      this.ip_backup = ip_backup;
      this.ip_gerenciamento = ip_gerenciamento;
   }
}
