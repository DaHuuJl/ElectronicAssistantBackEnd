//package ru.cchgeu.electronicassistantbackend.utils;
//
//public class Signature {
//        public static byte[] samplePDFSignature(String[] aliases, byte[] data, char pdfVersion) throws SignatureProcessorException {
//        ByteArrayOutputStream bais = new ByteArrayOutputStream();
//        HashMap<X509Certificate, PrivateKey> currSignAttrMap = new HashMap<X509Certificate, PrivateKey>();
//        for (String alias : aliases) {
//            X509Certificate certificate = (X509Certificate) signAttributesMap1.get(alias)[0];
//            PrivateKey privateKey = (PrivateKey) signAttributesMap1.get(alias)[1];
//
//            currSignAttrMap.put(certificate, privateKey);
//            if (certificate == null) {
//                throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + CERTIFICATE_NOT_FOUND_BY_ALIAS);
//            }
//
//            if (privateKey == null) {
//                throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + PRIVATE_KEY_NOT_FOUND_BY_ALIAS);
//            }
//        }
//        try {
//            FileInputStream fis = new FileInputStream(new File(FILE_PATH));
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            byte[] buf = new byte[1024];
//            int n = 0;
//            while ((n = fis.read(buf, 0, buf.length)) != -1) {
//                baos.write(buf, 0, n);
//            }
//            fis.close();
//            byte[] im = baos.toByteArray();
//
//            X509Certificate innerCA = obtainCertFromTrustStoreJKS(false, INNER_CA);
//            PdfStamper stp = null;
//            PdfReader reader = null;
//            int pageNumber = 1;
//            for (Entry<X509Certificate, PrivateKey> entry : currSignAttrMap.entrySet()) {
//                if (bais.toByteArray().length == 0) {
//                    reader = new PdfReader(data);
//                } else {
//                    reader = new PdfReader(bais.toByteArray());
//                    bais = new ByteArrayOutputStream();
//                }
//                stp = PdfStamper.createSignature(reader, bais, pdfVersion); //'\0'
//                Certificate[] certPath = new Certificate[] {entry.getKey(), innerCA};
//                PdfSignatureAppearance sap = stp.getSignatureAppearance();
//                sap.setProvider("JCSP"); //JCP
//                sap.setCrypto(entry.getValue(), certPath, null,
//                        PdfSignatureAppearance.CRYPTOPRO_SIGNED);
//                Image image = Image.getInstance(im);
//                sap.setImage(image);
//                sap.setVisibleSignature(new Rectangle(150, 150), pageNumber, null);
//                pageNumber++;
//                stp.close();
//                bais.close();
//                reader.close();
//            }
//        } catch (RuntimeException e) {
//            throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + ExceptionUtils.getFullStackTrace(e));
//        } catch (IOException e) {
//            throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + ExceptionUtils.getFullStackTrace(e));
//        } catch (DocumentException e) {
//            throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + ExceptionUtils.getFullStackTrace(e));
//        } catch (CertificateEncodingException e) {
//            throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + ExceptionUtils.getFullStackTrace(e));
//        } catch (Exception e) {
//            throw new SignatureProcessorException(PDF_SIGNATURE_ERROR + ExceptionUtils.getFullStackTrace(e));
//        }
//        return bais.toByteArray();
//    }
//}
