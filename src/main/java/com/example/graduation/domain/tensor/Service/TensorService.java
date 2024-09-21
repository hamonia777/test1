package com.example.graduation.domain.tensor.Service;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.ndarray.FloatNdArray;
import org.tensorflow.ndarray.NdArrays;
import org.tensorflow.ndarray.Shape;
import org.tensorflow.types.TFloat32;
import org.springframework.stereotype.Service;

@Service
public class TensorService {

    public void category() {
        try (SavedModelBundle model = SavedModelBundle.load("model-directory")) {

            // 입력 데이터를 위한 텐서 생성 (TFloat32)
            float[][] inputData = new float[][]{{1.0f, 2.0f, 3.0f}};
            FloatNdArray inputNdArray = NdArrays.ofFloats(Shape.of(1, 3));  // Shape 지정

            // NdArray에 데이터를 개별적으로 작성
            for (int i = 0; i < inputData.length; i++) {
                for (int j = 0; j < inputData[i].length; j++) {
                    inputNdArray.setFloat(inputData[i][j], i, j);  // NdArray에 데이터 쓰기
                }
            }

            TFloat32 inputTensor = TFloat32.tensorOf(inputNdArray);  // NdArray로부터 TFloat32 텐서 생성

            // 모델에 입력하여 예측 실행
            TFloat32 output = (TFloat32) model.session().runner()
                    .feed("input_tensor_name", inputTensor)
                    .fetch("output_tensor_name")
                    .run()
                    .get(0);

            // 출력 결과 처리 (NdArray로 변환)
            FloatNdArray outputData = NdArrays.ofFloats(Shape.of(1, 3));  // 출력 Shape 지정
            output.copyTo(outputData);  // 결과를 NdArray에 복사

            // 결과 출력
            System.out.println("모델 예측 결과: " + outputData.getFloat(0, 0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
